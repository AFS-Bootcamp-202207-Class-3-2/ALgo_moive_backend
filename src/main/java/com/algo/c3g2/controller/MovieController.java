package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.MovieSearchRequest;
import com.algo.c3g2.controller.mapper.MovieMapper;
import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping
    public Response getMovies(@RequestBody MovieSearchRequest movieSearchRequest){
        Page<Movie> movies = movieService.getMovies(movieSearchRequest);
        return Response.SUCCESS().data("movies",movies);
    }
}
