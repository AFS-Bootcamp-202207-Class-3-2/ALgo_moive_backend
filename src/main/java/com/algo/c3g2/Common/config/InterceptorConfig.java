package com.algo.c3g2.common.config;

import com.algo.c3g2.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> patterns = new ArrayList<String>();
//        patterns.add("/users/register");
//        patterns.add("/login");
//        patterns.add("/movies/**");
//        patterns.add("/sessions/**");
//        patterns.add("/cinemas/**");
//
//
//        registry.addInterceptor(jwtInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(patterns);
//
//    }



    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
