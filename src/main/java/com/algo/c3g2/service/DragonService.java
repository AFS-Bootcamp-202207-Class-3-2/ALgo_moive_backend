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

    public Response getOrderByDragon(String movieId) {
        List<Session> sessionList = sessionRepository.findAllByMovieId(movieId);
        Date now = new Date();
        //全部小于当前时间的场次
        List<Session> sessions = sessionList.stream()
                .filter(session -> session.getStartTime().getTime() > now.getTime())
                .sorted(Comparator.comparing(Session::getStartTime)).collect(Collectors.toList());
        if(!ObjectUtil.isEmpty(sessions)){
            //找到有座位的场次
            Session existSession = sessions.stream()
                    .filter(session -> session.getSeatsInfo().indexOf('1')!=-1)
                    .findFirst()
                    .orElseThrow(SessionExistException::new);
            Integer firstEmptySeat = findFirstEmptySeat(existSession);
            Seat[] seats = {new Seat(0,firstEmptySeat,0,0)};
            OrderCreateRequest orderCreateRequest = new OrderCreateRequest(existSession.getId(),existSession.getPrice(),seats);
            return orderService.generateOrder(orderCreateRequest);
        }
        return Response.FAIL("所有场次无空余座位！");
    }

    private Integer findFirstEmptySeat(Session session){
        int index = session.getSeatsInfo().indexOf('1');
        return index;
    }



}
