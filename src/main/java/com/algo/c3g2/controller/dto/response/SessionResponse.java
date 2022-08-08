package com.algo.c3g2.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {
    private String roomName;
    private String startTime;
    private String endTime;
    private String screeningDate;
}