package com.algo.c3g2.advice;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.constants.ExceptionConstants;
import com.algo.c3g2.exception.MovieExistException;
import com.algo.c3g2.exception.UserExistException;
import com.algo.c3g2.exception.UserNotExistException;
import com.algo.c3g2.exception.WrongPasswordException;
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
        return Response.FAIL(HttpStatus.NOT_IMPLEMENTED.toString(), ExceptionConstants.USER_EXIST);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UserNotExistException.class)
    public Response handleUserNotExistException(Exception exception) {
        log.error("-------------该用户名不存在----------");
        return Response.FAIL(HttpStatus.FORBIDDEN.toString(), ExceptionConstants.USER_NOTEXIST);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(WrongPasswordException.class)
    public Response handleWrongPasswordExistException(Exception exception) {
        log.error("-------------密码错误----------");
        return Response.FAIL(HttpStatus.FORBIDDEN.toString(), ExceptionConstants.PASSWORD_WRONG);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(MovieExistException.class)
    public Response handleMovieNotExistException(Exception exception) {
        log.error("-------------电影不存在----------");
        return Response.FAIL(HttpStatus.FORBIDDEN.toString(), ExceptionConstants.MOVIE_NOT_EXIST);
    }
}
