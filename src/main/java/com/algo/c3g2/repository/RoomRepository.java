package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findAllByCinemaId(String cinemaId);
}