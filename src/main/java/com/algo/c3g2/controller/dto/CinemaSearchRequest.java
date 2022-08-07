package com.algo.c3g2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaSearchRequest {

    private Integer page = 0;
    private Integer pageSize = 10;
    private String search;
}
