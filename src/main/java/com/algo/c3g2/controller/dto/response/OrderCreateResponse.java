package com.algo.c3g2.controller.dto.response;

import com.algo.c3g2.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateResponse {
    private String sessionId;
    private String movieId;
    private String cinemaId;
    private String roomId;
    private String userId;
    private double price;
    private Seat[] seats;
}
