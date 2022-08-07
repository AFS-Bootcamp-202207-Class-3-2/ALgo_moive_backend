package com.algo.c3g2.exception;

import com.algo.c3g2.constants.ExceptionConstants;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super(ExceptionConstants.USER_EXIST);
    }
}