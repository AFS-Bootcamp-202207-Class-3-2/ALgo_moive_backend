package com.algo.c3g2.entity;

import com.algo.c3g2.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Column(name = "endT_time")
    private Date endTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "screening_time")
    private Date screeningDate;

    private double price;

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