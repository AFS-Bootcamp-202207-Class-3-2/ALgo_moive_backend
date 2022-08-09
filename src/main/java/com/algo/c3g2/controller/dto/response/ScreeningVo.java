package com.algo.c3g2.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ScreeningVo {

    private String roomName;
    private String startTime;
    private String endTime;
    private String screeningDate;
    private String seatsInfo;
    private double price;

    private String moive_type;
    private String language_version;
}
