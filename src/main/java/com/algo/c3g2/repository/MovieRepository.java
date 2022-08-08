package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Page<Movie> findAllByMovieNameContainingOrActorsContaining(String movieName, String actor, Pageable pageable);

    @Query(value = "select distinct tm.id,tm.movie_name,tm.actors,tm.movie_desc,tm.release_date,tm.score,tm.cover,tm.video,tm.duration, tm.duration_unit from t_session ts,t_room tr,t_movie tm where tr.id = ts.room_id and tr.cinema_id = ?1 and ts.movie_id = tm.id",nativeQuery = true)
    List<Movie> findMoviesByCinemaId(String cinemaId);
}
