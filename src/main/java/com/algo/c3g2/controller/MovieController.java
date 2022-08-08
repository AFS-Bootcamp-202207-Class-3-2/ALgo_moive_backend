package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.mapper.MovieMapper;
import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping
    public Response getMovies(@RequestParam(name = "page", defaultValue = "0") Integer page,
                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "sortType", defaultValue = "releaseDate") String sortType,
                              @RequestParam(name = "search", required = false) String search){
        Page<Movie> movies = movieService.getMovies(page, pageSize, sortType, search);
        return Response.SUCCESS().data("movies",movies);
    }

    @GetMapping("/{id}")
    public Response getMovieDetail(@PathVariable("id")String id){
        Movie movie = movieService.getMovieDetail(id);
        return Response.SUCCESS().data("movie",movie);
    }

    @GetMapping("/{cinemaId}/cinemas")
    public Response getMoviesByCinemaId(@PathVariable("cinemaId")String cinemaId){
        List<Movie> movies = movieService.getMoviesByCinemaId(cinemaId);
        return Response.SUCCESS().data("movies",movies);
    }
}
