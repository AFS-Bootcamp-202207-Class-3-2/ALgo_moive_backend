package com.algo.c3g2.service;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.OrderCreateRequest;
import com.algo.c3g2.controller.dto.OrderResponse;
import com.algo.c3g2.controller.dto.response.OrderCreateResponse;
import com.algo.c3g2.controller.mapper.SeatMapper;
import com.algo.c3g2.entity.*;
import com.algo.c3g2.exception.OrderNoExistException;
import com.algo.c3g2.repository.*;
import com.algo.c3g2.utils.QrCodeUtils;
import com.algo.c3g2.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Response generateOrderResponseById(String orderId) {
        Order orderFromDb = orderRepository.findById(orderId).orElseThrow(OrderNoExistException::new);
        Session session = sessionRepository.findById(orderFromDb.getSessionId()).get();
        Movie movie = movieRepository.findById(orderFromDb.getMovieId()).get();
        Cinema cinema = cinemaRepository.findById(orderFromDb.getCinemaId()).get();
        Room room = roomRepository.findById(orderFromDb.getRoomId()).get();
        User user = userRepository.findById(orderFromDb.getUserId()).get();

        StringBuilder seatInfoBuilder = new StringBuilder();
        String[] seatInfoData = orderFromDb.getSeatInfo().split(" ");
        for (int idx = 0; idx < seatInfoData.length; idx++) {
            String[] splitSeat = seatInfoData[idx].split("\\,");
            if (splitSeat.length >= 2) {
                seatInfoBuilder.append(String.format("%s???%s???", splitSeat[0], splitSeat[1]));
            }
            if (idx == seatInfoData.length - 1) break;
            seatInfoBuilder.append(" ");
        }

        OrderResponse orderResponse = new OrderResponse().setSeatInfo(seatInfoBuilder.toString())
                .setOrderId(orderId).setPrice(orderFromDb.getPrice()).setStatus(orderFromDb.getStatus())
                .setStartTime(session.getStartTime()).setEndTime(session.getEndTime()).setScreeningDate(session.getScreeningDate())
                .setMovieName(movie.getMovieName()).setMovieActors(movie.getActors()).setMovieDesc(movie.getMovieDesc()).setMovieReleaseDate(movie.getReleaseDate())
                .setMovieCover(movie.getCover()).setMovieDuration(movie.getDuration()).setMovieDurationUnit(movie.getDurationUnit())
                .setCinemaName(cinema.getCinemaName()).setCinemaAddress(cinema.getAddress())
                .setRoomName(room.getRoomName())
                .setUserAvatar(user.getAvatar()).setUserNickname(user.getNickname())
                .setUserPhone(user.getPhone());

        return Response.SUCCESS("???????????????????????????").data("data"
                , orderResponse);
    }

    public Response generateOrder(OrderCreateRequest request) {
        User user = TokenUtils.getCurrentUser();
        String sessionId = request.getSessionId();
        Seat[] seats = request.getSeats();
        double price = request.getPrice();
        Session session = sessionRepository.findById(sessionId).get();
        String localSeats = session.getSeatsInfo();
        for (Seat seat : seats) {
            int index = seat.getIndex();
            if(localSeats.charAt(index) == '0') {
                return Response.FAIL("????????????");
            }
            if(localSeats.charAt(index) == '2') {
                return Response.FAIL("???????????????");
            }
            seat.setState(2);
            localSeats = localSeats.substring(0, index) + '2' + localSeats.substring(index + 1);
        }
        Movie movie = movieRepository.findById(session.getMovieId()).get();
        Room room = roomRepository.findById(session.getRoomId()).get();
        Cinema cinema = cinemaRepository.findById(room.getCinemaId()).get();
        Order order = new Order(null, price, "0", sessionId, movie.getId(), cinema.getId(), room.getId(),
                user.getId(), new SeatMapper().toSeatInfo(seats),new Date());
        Order orderFromDb = orderRepository.save(order.setId(null).setStatus("0"));
        session.setSeatsInfo(localSeats);
        sessionRepository.save(session);
        OrderCreateResponse orderCreateResponse = new OrderCreateResponse();
        BeanUtils.copyProperties(orderFromDb, orderCreateResponse);
        return Response.SUCCESS("???????????????????????????").data("order", orderCreateResponse);
    }

    public void createQrCode(String orderId, HttpServletResponse response) {
        //???????????????????????????
//        Boolean loginState = (Boolean) redisUtils.get(Constants.User.KEY_PC_QR_LOGIN_ID + code);

        //???????????????
        //???????????????
        //1???????????????????????????code??????????????????????????????
        //?????????????????????????????????????????????App???????????????????????????????????????????????????
        //??????????????????????????????????????????????????????????????????????????????code
        //2????????????????????????App???????????????+code????????????????????????app????????????????????????????????????code????????????
        //?????????????????????????????????????????????app?????????????????????????????????????????????app??????????????????????????????app
        //APP_DOWNloAD_PATH/code
        HttpServletRequest request = getRequest();
        String servletPath = request.getServletPath();
        String originDomain = request.getRequestURL().toString().replace(servletPath, "");
        String content = originDomain +  "/order/pay/" + orderId;
        log.info("content ==> " + content);
        byte[] result = QrCodeUtils.encodeQrCode(content);
        response.setContentType(QrCodeUtils.RESPONSE_CONTENT_TYPE);
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(result);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }

    HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getResponse();
    }

    public Response payToChangeOrderState(String id) {
        Order order = orderRepository.findById(id).orElseThrow(OrderNoExistException::new);
        order.setStatus("1");
        Order orderFromDb = orderRepository.save(order);
        return Response.SUCCESS("??????????????????").data("order",orderFromDb);
    }

    public Response cycleQueryOrderState(String id) {
        Order order = orderRepository.findById(id).orElseThrow(OrderNoExistException::new);
        String status = order.getStatus();
        return status.equals("1") ? Response.SUCCESS("????????????")
                .data("order", order)
                : Response.FAIL("40000")
                .data("order", order);
    }

    public Response testToBackOrderState(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNoExistException::new);
        order.setStatus("0");
        Order orderFromDb = orderRepository.save(order);
        return Response.SUCCESS().data("order", orderFromDb);
    }

    public Response findByUserId(String userId,int page, int  pageSize) {
        page = (page - 1) * pageSize;
        System.out.println(page+" "+pageSize);
        int totalCount = orderRepository.countByUserId(userId);
        System.out.println(totalCount);
        List<Order> orderList = orderRepository.findAllByUserId(userId,page,pageSize);
        System.out.println(orderList.size());
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order value : orderList) {
            OrderResponse orderResponse = new OrderResponse();
            Order order = value;
            orderResponse.setOrderId(order.getId()).setCreateTime(value.getCreateTime());
            orderResponse.setCinemaName(cinemaRepository.findById(order.getCinemaId()).get().getCinemaName());
            orderResponse.setMovieName(movieRepository.findById(order.getMovieId()).get().getMovieName());
            orderResponse.setRoomName(roomRepository.findById(order.getRoomId()).get().getRoomName());
            orderResponse.setPrice(order.getPrice());
            orderResponse.setStatus(order.getStatus());
            orderResponse.setSeatInfo(order.getSeatInfo());
            orderResponse.setMovieCover(movieRepository.findById(order.getMovieId()).get().getCover());
            orderResponse.setStartTime(sessionRepository.findById(order.getSessionId()).get().getStartTime());
            orderResponse.setEndTime(sessionRepository.findById(order.getSessionId()).get().getEndTime());
            orderResponseList.add(orderResponse);
        }
        return Response.SUCCESS().data("orders",orderResponseList).data("totalCount",totalCount);
    }

    /**
     *
     * ????????????
     * @param orderId
     * @return
     */
    public Response deleteOrdersFromUserById(String orderId) {
        Order order = orderRepository.findById(orderId).get();
        String status = order.getStatus();

        if(status.equals("0")) {
            String seatInfo = order.getSeatInfo();
            String sessionId = order.getSessionId();
            Session session = sessionRepository.findById(sessionId).get();
            int sessionSize = (int) Math.sqrt(session.getSeatsInfo().length());
            String updateSeatInfo = revertSeatState(session, seatInfo, sessionSize);
            session.setSeatsInfo(updateSeatInfo);
            sessionRepository.save(session);
        }
        
        orderRepository.deleteById(orderId);
        return Response.SUCCESS("20001","???????????????????????????");
    }

    public void updateFinishQrCodeImage(String orderId, HttpServletResponse response) {
        HttpServletRequest request = getRequest();
        String servletPath = request.getServletPath();
        String originDomain = request.getRequestURL().toString().replace(servletPath, "");
        String content = originDomain +  "/order/update/finish/" + orderId;
        log.info("content ==> " + content);
        byte[] result = QrCodeUtils.encodeQrCode(content);
        response.setContentType(QrCodeUtils.RESPONSE_CONTENT_TYPE);
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(result);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response updateOrderFinish(String orderId) {
        Order orderFromDb = orderRepository.findById(orderId).orElseThrow(OrderNoExistException::new);
        orderFromDb.setStatus("2");
        Order saveOrder = orderRepository.save(orderFromDb);
        return Response.SUCCESS("2022", "????????????!!!").data("data", saveOrder);
    }
    public String revertSeatState(Session session, String seatInfo, int sessionSize) {
        String updateSeatInfo = session.getSeatsInfo();

        List<String> seatList = Arrays.asList(seatInfo.split(" "));
        for(String seat : seatList) {
            String[] seatNum = seat.split(",");
            int row = Integer.parseInt(seatNum[0]) - 1;
            int col = Integer.parseInt(seatNum[1]) - 1;
            int index = row * sessionSize + col;
            updateSeatInfo = updateSeatInfo.substring(0, index) + '1' + updateSeatInfo.substring(index + 1);
        }

        return updateSeatInfo;
    }

    public Response refundUnlockSeats(String orderId) {
        Order order = orderRepository.findById(orderId).get();
        String status = order.getStatus();

        if(status.equals("1")) {
            String seatInfo = order.getSeatInfo();
            String sessionId = order.getSessionId();
            Session session = sessionRepository.findById(sessionId).get();
            int sessionSize = (int) Math.sqrt(session.getSeatsInfo().length());
            String updateSeatInfo = revertSeatState(session, seatInfo, sessionSize);
            session.setSeatsInfo(updateSeatInfo);
            sessionRepository.save(session);
        }else {
            return Response.FAIL("????????????").data("order", order);
        }
        order.setStatus("3");
        Order saveOrder = orderRepository.save(order);
        return Response.SUCCESS("20002","?????????????????????").data("order",saveOrder);
    }

    public Response refundDeleteOrdersFromUserById(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNoExistException::new);
        orderRepository.delete(order);
        return Response.SUCCESS("2022", "????????????????????????").data("order", order);
    }

}
