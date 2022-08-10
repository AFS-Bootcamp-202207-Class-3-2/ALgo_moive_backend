package com.algo.c3g2.controller.mapper;

import com.algo.c3g2.controller.dto.response.SessionSeatsResponse;
import com.algo.c3g2.entity.*;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {
    public SessionSeatsResponse toSessionResponse(Session session, Movie movie, Cinema cinema, Room room) {
        String seats = session.getSeatsInfo();
        int sizeLength = (int) Math.sqrt(seats.length());
        Seat[][] seatsList= new Seat[sizeLength][sizeLength];
        int seatIndex = 0;
        for(int row = 0; row < sizeLength; row++) {
            for(int col = 0; col < sizeLength; col++) {
                seatsList[row][col] = new Seat(seats.charAt(seatIndex) - '0', seatIndex++, row + 1, col + 1);
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
}
