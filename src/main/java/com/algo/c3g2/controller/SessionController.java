package com.algo.c3g2.controller;

import com.algo.c3g2.common.AuthAccess;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.mapper.SessionMapper;
import com.algo.c3g2.entity.Cinema;
import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.entity.Room;
import com.algo.c3g2.entity.Session;
import com.algo.c3g2.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @Autowired
    SessionMapper sessionMapper;

    @GetMapping("/{id}")
    @AuthAccess
    public Response getSessionInfoAndSeatsInfoBySessionId(@PathVariable("id")String id){
        Session session = sessionService.getSessionById(id);
        Movie movie = sessionService.findMovieByMovieId(session.getMovieId());
        Room room = sessionService.findRoomByRoomId(session.getRoomId());
        Cinema cinema = sessionService.findCinemaByCinemaId(room.getCinemaId());
        return Response.SUCCESS().data("sessionInfo", sessionMapper.toSessionResponse(session, movie, cinema, room));
    }

    @GetMapping("/{cinemaId}/{movieId}")
    @AuthAccess
    public Response getSessionListByCinemaIdAndMovieId(@PathVariable("cinemaId") String cinemaId,
                                                       @PathVariable("movieId") String movieId) {
        List<Session> sessionList = sessionService.findSessionListByCinemaIdAndMovieId(cinemaId, movieId);
        return Response.SUCCESS().data("size", sessionList.size())
                .data("sessionList", sessionMapper.toResponse(sessionList));
    }
}
