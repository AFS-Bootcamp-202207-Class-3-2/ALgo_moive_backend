package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.CinemaSearchRequest;
import com.algo.c3g2.entity.Cinema;
import com.algo.c3g2.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping
    public Response getCinemas(@RequestBody CinemaSearchRequest cinemaSearchRequest){
        Page<Cinema> cinemas = cinemaService.getCinemas(cinemaSearchRequest);
        return Response.SUCCESS().data("cinemas", cinemas);
    }

    @GetMapping("/{movieId}/movies")
    public Response getCinemasByMovieId(@PathVariable("movieId")String movieId){
        List<Cinema> cinemas = cinemaService.getCinemasByMovieId(movieId);
        return Response.SUCCESS().data("cinemas", cinemas);
    }
}
