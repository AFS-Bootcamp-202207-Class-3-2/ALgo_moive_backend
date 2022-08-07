package com.algo.c3g2.exception;

import com.algo.c3g2.constants.Constants;


public class UserExistException extends RuntimeException{
    public UserExistException() {
        super(Constants.USER_EXIST);
    }
}
