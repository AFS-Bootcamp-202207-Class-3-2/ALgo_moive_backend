package com.algo.c3g2.service;

import com.algo.c3g2.controller.dto.MovieSearchRequest;
import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> getMovies(MovieSearchRequest movieSearch) {
        Sort sort = Sort.by(Sort.Direction.DESC, movieSearch.getSortType());
        Pageable pageable = PageRequest.of(movieSearch.getPage(), movieSearch.getPageSize(), sort);
        Page<Movie> movies;
        String search = movieSearch.getSearch();
        if(search != null){
            movies = movieRepository.findAllByMovieNameContainingOrActorsContaining(search, search, pageable);
        }else{
            movies = movieRepository.findAll(pageable);
        }
        return movies;
    }
}
