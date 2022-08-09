package com.algo.c3g2.controller;

import com.algo.c3g2.entity.Seat;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private String sessionId;
    private double price;
    private Seat[] seats;
}
