package com.algo.c3g2.entity;


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

    private Date releaseDate;

    private double Score;

    private String cover;

    private String video;

    private double duration;

    private String durationUnit;
}
