package com.algo.c3g2.service;

import com.algo.c3g2.controller.dto.request.SessionRequest;
import com.algo.c3g2.entity.Cinema;
import com.algo.c3g2.entity.Movie;
import com.algo.c3g2.entity.Room;
import com.algo.c3g2.entity.Session;
import com.algo.c3g2.exception.SessionExistException;
import com.algo.c3g2.repository.CinemaRepository;
import com.algo.c3g2.repository.MovieRepository;
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

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

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

    public List<Session> findSessionListByCinemaId(String cinemaId) {
        List<Room> roomList = roomRepository.findAllByCinemaId(cinemaId);
        List<String> roomIds = roomList.stream()
                .map(Room::getId)
                .collect(Collectors.toList());
        return sessionRepository.findAllByRoomIdIn(roomIds);
    }

    public Movie findMovieByMovieId(String movieId) {
        return movieRepository.findById(movieId).get();
    }

    public Cinema findCinemaByCinemaId(String cinemaId) {
        return cinemaRepository.findById(cinemaId).get();
    }

    public Room findRoomByRoomId(String roomId) {
        return roomRepository.findById(roomId).get();
    }

    public List<Session> findSessionListByCinemaIdAndMovieIdAndFilterDate(SessionRequest sessionRequest) {
        List<Session> sessionListByCinemaIdAndMovieId = findSessionListByCinemaIdAndMovieId(sessionRequest.getCinemaId(), sessionRequest.getMovieId());
        String substring = sessionListByCinemaIdAndMovieId.get(0).getStartTime().toString().substring(6, 10);
        System.out.println(substring);

        List<Session> sessionListFilterBySessionRequest = sessionListByCinemaIdAndMovieId.stream()
                .filter(item ->
                        item.getStartTime().toString().substring(6, 10)
                                .equals(sessionRequest.getFilterDate()))
                .collect(Collectors.toList());
        Movie movie = findMovieByMovieId(sessionRequest.getMovieId());
        sessionListFilterBySessionRequest.forEach(
                item -> {
                    item.setLanguageVersion(movie.getLanguageVersion());
                    item.setRoomName(findRoomByRoomId(item.getRoomId()).getRoomName());
                });
        return sessionListFilterBySessionRequest;
    }
}
