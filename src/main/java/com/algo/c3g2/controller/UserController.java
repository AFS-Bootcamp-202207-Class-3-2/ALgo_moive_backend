package com.algo.c3g2.controller;

import com.algo.c3g2.common.AuthAccess;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.UserRequest;
import com.algo.c3g2.controller.dto.request.UserUpdateRequest;
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
    @AuthAccess
    public Response register(@RequestBody UserRequest userRequest) {
        if (isExistUser(userRequest.getUsername())) {
            throw(new UserExistException());
        }
        User user = userMapper.toEntity(userRequest);
        return userService.saveUser(user);
    }

    public Boolean isExistUser(String username) {
        return userService.isExistUser(username);
    }
    @PutMapping("/{id}")
    @AuthAccess
    public Response updateUser(@PathVariable("id") String id,@RequestBody UserUpdateRequest userUpdateRequest){
      return userService.updateUser(id, userMapper.toUpdateEntity(userUpdateRequest));
    }
}
