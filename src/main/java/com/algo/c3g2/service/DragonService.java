package com.algo.c3g2.service;

import cn.hutool.core.util.ObjectUtil;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.OrderCreateRequest;
import com.algo.c3g2.entity.Order;
import com.algo.c3g2.entity.Seat;
import com.algo.c3g2.entity.Session;
import com.algo.c3g2.exception.SessionExistException;
import com.algo.c3g2.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DragonService {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    OrderService orderService;

    public Response getOrderByDragon(String movieId, Integer number) {
        List<Session> sessionList = sessionRepository.findAllByMovieId(movieId);
        Date now = new Date();
        //全部小于当前时间的场次
        List<Session> sessions = sessionList.stream()
                .filter(session -> session.getStartTime().getTime() > now.getTime())
                .sorted(Comparator.comparing(Session::getStartTime)).collect(Collectors.toList());
        if(!ObjectUtil.isEmpty(sessions)){
            //找到有座位的场次
            Session existSession = sessions.stream()
                    .filter(session -> checkEmptySeatsInCinema(session, number) != -1)
                    .findFirst()
                    .orElseThrow(SessionExistException::new);
            Seat[] seats = findFirstEmptySeats(existSession, number);
            String priceString = String.format("%.2f", number * existSession.getPrice());
            double price = Double.parseDouble(priceString);
            OrderCreateRequest orderCreateRequest = new OrderCreateRequest(existSession.getId(), price, seats);
            return orderService.generateOrder(orderCreateRequest);
        }
        return Response.FAIL("所有场次无空余座位！");
    }

    private int checkEmptySeatsInCinema(Session session, Integer number){
        String seatsInfo = session.getSeatsInfo();
        int sessionSize = (int) Math.sqrt(seatsInfo.length());
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i< number; i++) {
            stringBuffer.append('1');
        }
        String needSeats = stringBuffer.toString();
        for (int i = 0; i < sessionSize; i++) {
            int index = seatsInfo.substring(i * sessionSize, (i + 1) * sessionSize).indexOf(needSeats);
            if(index != -1){
                return i * sessionSize + index;
            }
        }
        return -1;
    }

    private Seat[] findFirstEmptySeats(Session session, Integer number){
        int index = checkEmptySeatsInCinema(session, number);
        Seat[] seats = new Seat[number];
        for(int i = 0 ; i < number; i++) {
            seats[i] = new Seat(0, index + i, 0, 0);
        }
        return seats;
    }
}
