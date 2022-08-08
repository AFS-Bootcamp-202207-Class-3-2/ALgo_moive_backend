package com.algo.c3g2.controller;

import cn.hutool.http.HttpStatus;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.UserRequest;
import com.algo.c3g2.controller.mapper.UserMapper;
import com.algo.c3g2.entity.User;
import com.algo.c3g2.exception.UserNotExistException;
import com.algo.c3g2.exception.WrongPasswordException;
import com.algo.c3g2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping()
    public Response login(@RequestBody UserRequest userRequest) {
        if (!isExistUser(userRequest.getUsername())) {
            throw(new UserNotExistException());
        }
        User user = userService.findByUserName(userRequest.getUsername());
        if (userRequest.getPassword().equals(user.getPassword()))
        {
            return Response.SUCCESS().data("user",user);
        }
        throw(new WrongPasswordException());

    }

    public Boolean isExistUser(String username) {
        return userService.isExistUser(username);
    }
}
