package com.algo.c3g2.exception;

import com.algo.c3g2.constants.constants;


public class UserExistException extends RuntimeException{
    public UserExistException() {
        super(constants.USER_EXIST);
    }
}
