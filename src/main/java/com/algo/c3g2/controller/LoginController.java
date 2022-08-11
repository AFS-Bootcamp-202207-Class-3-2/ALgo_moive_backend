package com.algo.c3g2.controller;

import cn.hutool.http.HttpStatus;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.UserRequest;
import com.algo.c3g2.controller.mapper.UserMapper;
import com.algo.c3g2.entity.User;
import com.algo.c3g2.exception.UserNotExistException;
import com.algo.c3g2.exception.WrongPasswordException;
import com.algo.c3g2.service.UserService;
import com.algo.c3g2.utils.MD5;
import com.algo.c3g2.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping()
    public Response login(@RequestBody UserRequest userRequest) {
        if (!isExistUser(userRequest.getUsername())) {
            throw(new UserNotExistException());
        }
        User user = userService.findByUserName(userRequest.getUsername());
        String password = MD5.md5(userRequest.getPassword());
        if (password.equals(user.getPassword()))
        {
            String token = TokenUtils.genToken(user.getId(), user.getPassword());
            user.setToken(token);
            return Response.SUCCESS(HttpStatus.HTTP_CREATED+"","登录成功！").data("user",user);
        }
        throw(new WrongPasswordException());

    }

    public Boolean isExistUser(String username) {
        return userService.isExistUser(username);
    }
}
