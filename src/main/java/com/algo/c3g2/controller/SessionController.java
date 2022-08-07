package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.mapper.SessionMapper;
import com.algo.c3g2.entity.Session;
import com.algo.c3g2.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @Autowired
    SessionMapper sessionMapper;

    @GetMapping("/{id}/seats")
    public Response getSeatsInfoBySessionId(@PathVariable("id")String id){
        Session session = sessionService.getSessionById(id);
        return Response.SUCCESS().data("seats", sessionMapper.toSessionSeats(session));
    }
}
