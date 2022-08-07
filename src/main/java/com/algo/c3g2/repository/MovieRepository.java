package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Page<Movie> findAllByMovieNameContainingOrActorsContaining(String movieName, String actor, Pageable pageable);

}
