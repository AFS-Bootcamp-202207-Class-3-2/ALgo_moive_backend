package com.algo.c3g2.exception;

import com.algo.c3g2.constants.constants;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super(constants.USER_EXIST);
    }
}