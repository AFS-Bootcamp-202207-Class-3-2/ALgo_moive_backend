package com.algo.c3g2.exception;

import com.algo.c3g2.constants.ExceptionConstants;


public class UserExistException extends RuntimeException{
    public UserExistException() {
        super(ExceptionConstants.USER_EXIST);
    }
}
