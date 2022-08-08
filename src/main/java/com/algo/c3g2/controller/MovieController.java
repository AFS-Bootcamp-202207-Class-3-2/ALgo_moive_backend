package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.mapper.MovieMapper;
import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/carousel")
    public Response getCarousel(){
        List<String> carousel = new ArrayList<String>(){{
            add("https://p0.pipi.cn/friday/531b7d1311fcb84b463e313bd92fc843.jpg?imageMogr2/thumbnail/2500x2500%3E");
            add("https://p0.pipi.cn/friday/5f2b6ade1978d976b8351f35a1409eac.jpg?imageMogr2/thumbnail/2500x2500%3E");
            add("https://p0.pipi.cn/friday/8f8a1458698cb629fe91a28f699e4da3.jpg?imageMogr2/thumbnail/2500x2500%3E");
            add("https://p0.pipi.cn/friday/70d508a1154316ca854d4b29ea3558b3.jpg?imageMogr2/thumbnail/2500x2500%3E");
            add("https://p0.pipi.cn/friday/5550cd82bbc9c4705c86b3f776682635.jpg?imageMogr2/thumbnail/2500x2500%3E");
        }};
        return Response.SUCCESS().data("carousel",carousel);
    }

}
