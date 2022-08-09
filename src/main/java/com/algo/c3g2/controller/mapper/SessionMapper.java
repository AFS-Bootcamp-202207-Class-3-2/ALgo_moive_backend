package com.algo.c3g2.controller.mapper;

import com.algo.c3g2.controller.dto.response.SessionResponse;
import com.algo.c3g2.controller.dto.response.SessionSeatsResponse;
import com.algo.c3g2.entity.*;
import com.algo.c3g2.repository.RoomRepository;
import com.algo.c3g2.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SessionMapper {
    @Autowired
    private RoomRepository roomRepository;

    public SessionSeatsResponse toSessionResponse(Session session, Movie movie, Cinema cinema, Room room) {
        String seats = session.getSeatsInfo();
        int sizeLength = (int) Math.sqrt(seats.length());
        Seat[][] seatsList= new Seat[sizeLength][sizeLength];
        int seatIndex = 0;
        for(int row = 0; row < sizeLength; row++) {
            for(int col = 0; col < sizeLength; col++) {
                seatsList[row][col] = new Seat(seats.charAt(seatIndex) - '0', seatIndex++);
            }
        }
        return new SessionSeatsResponse(
                movie.getMovieName(),
                movie.getMovieType(),
                (int) movie.getDuration() + "分钟",
                cinema.getCinemaName(),
                room.getRoomName(),
                session.getStartTime(),
                session.getPrice(),
                movie.getCover(),
                seatsList
        );
    }

    public HashMap<String, List<SessionResponse>> toResponse(List<Session> sessionList) {
        List<SessionResponse> sessionResponses = getSessionResponses(sessionList);
        HashMap<String, List<SessionResponse>> map = new HashMap<>();
        sessionResponses.forEach(sessionResponse -> {
            String screeningDate = sessionResponse.getScreeningDate();
            List<SessionResponse> dateMapResponse;
            if (map.containsKey(screeningDate)) {
                dateMapResponse = map.get(screeningDate);
            } else {
                dateMapResponse = new ArrayList<>();
            }
            dateMapResponse.add(sessionResponse);
            map.put(screeningDate, dateMapResponse);
        });
        return map;
    }

    private List<SessionResponse> getSessionResponses(List<Session> sessionList) {
        List<SessionResponse> sessionResponses = new ArrayList<>();
        sessionList.forEach(session -> {
            SessionResponse response = new SessionResponse();
            response.setStartTime(DateUtil.localDateTimeToString(session.getStartTime()).substring(11));
            response.setEndTime(DateUtil.localDateTimeToString(session.getEndTime()).substring(11));
            response.setScreeningDate(DateUtil.localDateTimeToString(session.getScreeningDate()).substring(0,10));
            Room room = roomRepository.findById(session.getRoomId()).get();
            response.setRoomName(room.getRoomName());
            sessionResponses.add(response);
        });
        return sessionResponses;
    }
}
