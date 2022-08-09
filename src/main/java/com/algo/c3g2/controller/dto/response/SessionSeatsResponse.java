package com.algo.c3g2.controller.dto.response;

import com.algo.c3g2.entity.Seat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SessionSeatsResponse {
    private String movieName;
    private String movieType;
    private String duration;
    private String cinemaName;
    private String roomName;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    private LocalDateTime startTime;
    private double price;
    private String poster;
    private Seat[][] seats;
}
