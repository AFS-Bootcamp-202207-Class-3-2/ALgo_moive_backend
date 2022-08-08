package com.algo.c3g2.service;

import com.algo.c3g2.entity.Room;
import com.algo.c3g2.entity.Session;
import com.algo.c3g2.exception.SessionExistException;
import com.algo.c3g2.repository.RoomRepository;
import com.algo.c3g2.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    private RoomRepository roomRepository;

    public Session getSessionById(String id) {
        return sessionRepository.findById(id).orElseThrow(SessionExistException::new);
    }

    public List<Session> findSessionListByCinemaIdAndMovieId(String cinemaId, String movieId) {
        List<Room> roomList = roomRepository.findAllByCinemaId(cinemaId);
        List<String> roomIds = roomList.stream()
                .map(Room::getId)
                .collect(Collectors.toList());
        return sessionRepository.findAllByMovieIdAndRoomIdIn(movieId, roomIds);
    }
}
