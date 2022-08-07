package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    List<Session> findAllByMovieId(String movieId);
    List<Session> findAllByMovieIdAndRoomIdIn(String movieId, List<String> roomIds);
}
