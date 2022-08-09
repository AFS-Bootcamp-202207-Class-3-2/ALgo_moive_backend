package com.algo.c3g2.service;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.OrderCreateRequest;
import com.algo.c3g2.controller.dto.OrderResponse;
import com.algo.c3g2.controller.mapper.SeatMapper;
import com.algo.c3g2.entity.*;
import com.algo.c3g2.exception.OrderNoExistException;
import com.algo.c3g2.repository.*;
import com.algo.c3g2.utils.QrCodeUtils;
import com.algo.c3g2.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        OrderResponse orderResponse = new OrderResponse()
                .setOrderId(orderId).setPrice(orderFromDb.getPrice()).setStatus(orderFromDb.getStatus())
                .setStartTime(session.getStartTime()).setEndTime(session.getEndTime()).setScreeningDate(session.getScreeningDate())
                .setMovieName(movie.getMovieName()).setMovieActors(movie.getActors()).setMovieDesc(movie.getMovieDesc()).setMovieReleaseDate(movie.getReleaseDate())
                .setMovieCover(movie.getCover()).setMovieDuration(movie.getDuration()).setMovieDurationUnit(movie.getDurationUnit())
                .setCinemaName(cinema.getCinemaName()).setCinemaAddress(cinema.getAddress())
                .setRoomName(room.getRoomName())
                .setUserAvatar(user.getAvatar()).setUserNickname(user.getNickname())
                .setUserPhone(user.getPhone());

        return Response.SUCCESS("得到订单信息成功！").data("data"
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
                return Response.FAIL("座位无效");
            }
            if(localSeats.charAt(index) == '2') {
                return Response.FAIL("座位已被选");
            }
            localSeats = localSeats.substring(0, index) + '2' + localSeats.substring(index + 1);
        }
        Movie movie = movieRepository.findById(session.getMovieId()).get();
        Room room = roomRepository.findById(session.getRoomId()).get();
        Cinema cinema = cinemaRepository.findById(room.getCinemaId()).get();
        Order order = new Order(null, price, "0", sessionId, movie.getId(), cinema.getId(), room.getId(),
                user.getId(), new SeatMapper().toSeatInfo(seats));
        Order orderFromDb = orderRepository.save(order.setId(null).setStatus("0"));
        session.setSeatsInfo(localSeats);
        sessionRepository.save(session);
        return Response.SUCCESS("生成订单信息成功！").data("data",orderFromDb);
    }

    public void createQrCode(String orderId, HttpServletResponse response) {
        //检查二维码是否过期
//        Boolean loginState = (Boolean) redisUtils.get(Constants.User.KEY_PC_QR_LOGIN_ID + code);

        //生成二维码
        //二维码内容
        //1、可以是简单的一个code，也就是传进来的这个
        //这种情况，如果是用我们自己写的App扫描，是识别并解析，请求对应的接口
        //如果是第三方的来扫描，可以识别，但是没有用，只能显示code
        //2、我们应该是一个App的下载地址+code，如果是我们自己app扫到，切割后面的内容拿到code进行解析
        //请求对应的接口，如果是第三方的app扫到，他是个网址，就会访问下载app的地址，去下载我们的app
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
        return Response.SUCCESS("订单支付成功").data("order",orderFromDb);
    }

    public Response cycleQueryOrderState(String id) {
        Order order = orderRepository.findById(id).orElseThrow(OrderNoExistException::new);
        String status = order.getStatus();
        return status.equals("1") ? Response.SUCCESS("支付成功")
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
}
