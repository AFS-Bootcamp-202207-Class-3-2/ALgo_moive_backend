package com.algo.c3g2.service;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.OrderResponse;
import com.algo.c3g2.entity.*;
import com.algo.c3g2.exception.OrderNoExistException;
import com.algo.c3g2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
                .setUserAvatar(user.getAvatar()).setUserNickname(user.getNickname());

        return Response.SUCCESS("得到订单信息成功！").data("data"
                , orderResponse);
    }

    public Response generateOrder(Order order) {
        Order orderFromDb = orderRepository.save(order.setId(null).setStatus("0"));
        return Response.SUCCESS("生成订单信息成功！").data("data",orderFromDb);
    }
}
