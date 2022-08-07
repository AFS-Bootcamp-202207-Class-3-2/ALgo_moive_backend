package com.algo.c3g2.exception;


import com.algo.c3g2.constants.ExceptionConstants;

public class MovieExistException extends RuntimeException{
    public MovieExistException() {
        super(ExceptionConstants.MOVIE_NOT_EXIST);
    }
}
