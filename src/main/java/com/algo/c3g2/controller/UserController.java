package com.algo.c3g2.controller;

import cn.hutool.http.HttpStatus;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.UserRequest;
import com.algo.c3g2.controller.mapper.UserMapper;
import com.algo.c3g2.entity.User;
import com.algo.c3g2.exception.UserExistException;
import com.algo.c3g2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/register")
    public Response register(@RequestBody UserRequest userRequest) {
        if (isExistUser(userRequest.getUsername())) {
            throw(new UserExistException());
        }
        User user = userMapper.toEntity(userRequest);
        user.setNickname(user.getUsername());
        try {
            User saveUser = userService.saveUser(user);
            return Response.SUCCESS(HttpStatus.HTTP_CREATED+"","注册成功！").data("data", saveUser);
        } catch (Exception exception) {
            return Response.FAIL(exception.getMessage());
        }
    }

    public Boolean isExistUser(String username) {
        return userService.isExistUser(username);
    }
}
