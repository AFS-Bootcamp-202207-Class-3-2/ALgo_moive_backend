package com.algo.c3g2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(generator = "snowflake")
    @GenericGenerator(name = "snowflake",strategy = "com.algo.c3g2.utils.SnowFlakeUtil")
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String sign;
    private String phone;
    private String status;
    private String role_id ;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    @Column(name = "create_time")
    @CreatedDate
    private LocalDate createTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:ss:mm",timezone="GMT+8")
    @Column(name = "update_time")
    @LastModifiedDate
    private LocalDate updateTime;
}
