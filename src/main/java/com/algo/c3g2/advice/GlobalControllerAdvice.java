package com.algo.c3g2.advice;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.constants.constants;
import com.algo.c3g2.exception.UserExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(UserExistException.class)
    public Response handleUserExistException(Exception exception) {
        log.error("-------------该用户名已存在----------");
        return Response.FAIL(HttpStatus.NOT_IMPLEMENTED.toString(), constants.USER_EXIST);
    }
}
