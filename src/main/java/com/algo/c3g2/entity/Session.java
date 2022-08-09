package com.algo.c3g2.entity;

import com.algo.c3g2.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    private LocalDateTime startTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "screening_date")
    private LocalDateTime screeningDate;

    private double price;

    @Transient
    private String languageVersion;


    public Session(String id, String roomId, String movieId, String seatsInfo) {
        this.id = id;
        this.roomId = roomId;
        this.movieId = movieId;
        this.seatsInfo = seatsInfo;
        Date date = new Date();
        this.startTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.endTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.screeningDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 使用示例
     * @param args
     */
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(DateUtil.localDateTimeToDate(now));

        System.out.println(DateUtil.localDateTimeToString(now));
    }
}
