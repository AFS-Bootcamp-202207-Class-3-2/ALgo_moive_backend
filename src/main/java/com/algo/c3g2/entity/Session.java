package com.algo.c3g2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_session")
public class Session {


    @Id
    @GeneratedValue(generator = "snowflake")
    @GenericGenerator(name = "snowflake", strategy = "com.algo.c3g2.utils.SnowFlakeUtil")
    private String id;

    private String roomId;

    private String movieId;

    private String seatsInfo;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    @Column(name = "start_time")
    private Date startTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    @Column(name = "end_time")
    private Date endTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "screening_date")
    private Date screeningDate;

    private double price;

    @Transient
    private String languageVersion;

    @Transient
    private String roomName;

    public Session(String id, String roomId, String movieId, String seatsInfo) {
        this.id = id;
        this.roomId = roomId;
        this.movieId = movieId;
        this.seatsInfo = seatsInfo;
        this.startTime = new Date();
        this.endTime = new Date();
        this.screeningDate = new Date();
    }

}
