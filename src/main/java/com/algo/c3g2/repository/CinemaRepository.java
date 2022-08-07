package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, String> {
    Page<Cinema> findAllByCinemaNameContaining(String search, Pageable pageable);

    @Query(value = "select distinct tc.id,tc.cinema_name,tc.address from t_session ts,t_room tr,t_cinema tc where ts.movie_id = ?1 and tr.id = ts.room_id and tc.id = tr.cinema_id", nativeQuery = true)
    List<Cinema> findCinemasByMovieId(String movieId);
}
