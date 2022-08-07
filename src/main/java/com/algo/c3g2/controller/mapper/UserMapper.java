package com.algo.c3g2.controller.mapper;

import com.algo.c3g2.controller.dto.UserRequest;
import com.algo.c3g2.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }
}
