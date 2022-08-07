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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(generator = "snowflake")
    @GenericGenerator(name = "snowflake",strategy = "com.algo.c3g2.utils.SnowFlakeUtil")
    private String id;

    private double price;

    private String status;

    private String sessionId;

    private String movieId;

    private String cinemaId;

    private String roomId;

    private String userId;

    private String seatInfo;
}
