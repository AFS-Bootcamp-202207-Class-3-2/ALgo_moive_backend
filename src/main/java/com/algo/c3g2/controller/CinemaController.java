package com.algo.c3g2.controller;

import com.algo.c3g2.common.AuthAccess;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.CinemaSearchRequest;
import com.algo.c3g2.entity.Cinema;
import com.algo.c3g2.entity.Session;
import com.algo.c3g2.service.CinemaService;
import com.algo.c3g2.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private SessionService sessionService;

    @PostMapping
    @AuthAccess
    public Response getCinemas(@RequestBody CinemaSearchRequest cinemaSearchRequest){
        Page<Cinema> cinemas = cinemaService.getCinemas(cinemaSearchRequest);
        return Response.SUCCESS().data("cinemas", cinemas);
    }

    @GetMapping
    @AuthAccess
    public Response getCinemas(@RequestParam(value = "movieId",required = false)String movieId){
        List<Cinema> cinemas;
        if(movieId !=null){
            cinemas = cinemaService.getCinemasByMovieId(movieId);
        }else{
            cinemas = cinemaService.findAll();
        }
        return Response.SUCCESS().data("cinemas", cinemas);
    }

    @GetMapping("/{cinemaId}")
    @AuthAccess
    public Response getCinemaByCinemaId(@PathVariable("cinemaId")String cinemaId){
        Cinema cinema = cinemaService.findCinemaByCinemaId(cinemaId);
        List<Session> sessions = sessionService.findSessionListByCinemaId(cinemaId);
        return Response.SUCCESS().data("cinema",cinema).data("sessions",sessions);
    }
}
