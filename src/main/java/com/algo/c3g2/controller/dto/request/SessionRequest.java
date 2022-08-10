package com.algo.c3g2.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SessionRequest {
    private String cinemaId ;
    private String movieId ;
    private String filterDate;

}
