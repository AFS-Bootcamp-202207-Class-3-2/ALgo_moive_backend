package com.algo.c3g2.controller.mapper;

import com.algo.c3g2.entity.Seat;
import com.algo.c3g2.entity.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {
    public Seat[][] toSessionSeats(Session session) {
        String seats = session.getSeatsInfo();
        int sizeLength = (int) Math.sqrt(seats.length());
        Seat[][] seatsList= new Seat[sizeLength][sizeLength];
        int seatIndex = 0;
        for(int row = 0; row < sizeLength; row++) {
            for(int col = 0; col < sizeLength; col++) {
                seatsList[row][col] = new Seat(seats.charAt(seatIndex) - '0', seatIndex++);
            }
        }
        return seatsList;
    }
}
