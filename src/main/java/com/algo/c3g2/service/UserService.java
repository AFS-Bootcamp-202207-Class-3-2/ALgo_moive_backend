package com.algo.c3g2.service;

import cn.hutool.http.HttpStatus;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.entity.User;
import com.algo.c3g2.exception.UserNotExistException;
import com.algo.c3g2.repository.UserRepository;
import com.algo.c3g2.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean isExistUser(String username) {
        return userRepository.existsByUsername(username);
    }

    public Response saveUser(User user) {

        user.setNickname(user.getUsername());
        user.setPassword(MD5.md5(user.getPassword()));
        try {
            User saveUser = userRepository.save(user);
            return Response.SUCCESS(HttpStatus.HTTP_CREATED+"","注册成功！").data("data", saveUser);
        } catch (Exception exception) {
            return Response.FAIL(exception.getMessage());
        }
    }


    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotExistException::new);
    }

    public Response updateUser(String id, User user) {
        User userById = findById(id);
        if(user.getNickname() != null){
            userById.setNickname(user.getNickname());
        }
        if(user.getPhone() != null){
            userById.setPhone(user.getPhone());
        }
        if(user.getSign() != null){
            userById.setSign(user.getSign());
        }
        User updatedUser = userRepository.save(userById);
        return Response.SUCCESS().data("user",updatedUser);
    }
}
