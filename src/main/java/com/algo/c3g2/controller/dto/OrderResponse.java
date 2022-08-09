package com.algo.c3g2.controller.dto;


import com.algo.c3g2.constants.DefaultConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
public class OrderResponse {
    private String orderId;
    private double price;
    private String status;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    private LocalDateTime startTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    private LocalDateTime endTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDateTime screeningDate;

    private String movieName;

    private String movieActors;

    private String movieDesc;

    private Date movieReleaseDate;

    private String movieCover;

    private double movieDuration;

    private String movieDurationUnit = DefaultConstants.DEFAULT_DURATION_UNIT;

    private String cinemaName;

    private String cinemaAddress;

    private String roomName;

    private String userNickname;

    private String userAvatar = DefaultConstants.DEFAULT_AVATAR;

    private String userPhone;

}
