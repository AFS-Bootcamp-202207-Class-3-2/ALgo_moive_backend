package com.algo.c3g2.service;

import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.exception.MovieExistException;
import com.algo.c3g2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> getMovies(Integer page, Integer pageSize, String sortType,String search) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortType);
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<Movie> movies;
        if(search != null){
            movies = movieRepository.findAllByMovieNameContainingOrActorsContaining(search, search, pageable);
        }else{
            movies = movieRepository.findAll(pageable);
        }
        return movies;
    }

    public Movie getMovieDetail(String id) {
        return movieRepository.findById(id).orElseThrow(MovieExistException::new);
    }

    public List<Movie> getMoviesByCinemaId(String cinemaId) {
        return movieRepository.findMoviesByCinemaId(cinemaId);
    }

    public List<Movie> findNowMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getReleaseDate().compareTo(new Date()) < 0).collect(Collectors.toList());
    }

    public List<Movie> findFutureMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getReleaseDate().compareTo(new Date()) > 0).collect(Collectors.toList());
    }
}
