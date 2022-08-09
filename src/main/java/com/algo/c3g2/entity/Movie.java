package com.algo.c3g2.entity;


import com.algo.c3g2.constants.DefaultConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_movie")
public class Movie {
    @Id
    @GeneratedValue(generator = "snowflake")
    @GenericGenerator(name = "snowflake",strategy = "com.algo.c3g2.utils.SnowFlakeUtil")
    private String id;

    private String movieName;

    private String actors;

    private String movieDesc;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    private Date releaseDate;

    private double score;

    private String cover;

    private String video;

    private int hotSpot;

    private double duration;

    private String movieType;

    private double boxOffice;

    private String durationUnit = DefaultConstants.DEFAULT_DURATION_UNIT;

    public Movie(String id, String movieName, String actors, String movieDesc) {
        this.id = id;
        this.movieName = movieName;
        this.actors = actors;
        this.movieDesc = movieDesc;
    }
}
