package com.algo.c3g2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class C3g2Application {

    public static void main(String[] args) {
        SpringApplication.run(C3g2Application.class, args);
    }

}
