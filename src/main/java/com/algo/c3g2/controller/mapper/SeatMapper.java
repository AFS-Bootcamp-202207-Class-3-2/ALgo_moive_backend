package com.algo.c3g2.controller.mapper;

import com.algo.c3g2.entity.Seat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeatMapper {
    public String toSeatInfo (Seat[] seats) {
        List<String> seatInfoList =
                Arrays.stream(seats)
                        .map(seat -> String.format("%d,%d", seat.getRow(), seat.getCol()))
                        .collect(Collectors.toList());
        return String.join(" ", seatInfoList);
    }
}
