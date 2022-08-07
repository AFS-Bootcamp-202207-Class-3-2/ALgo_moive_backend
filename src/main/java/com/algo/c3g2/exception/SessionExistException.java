package com.algo.c3g2.exception;

import com.algo.c3g2.constants.ExceptionConstants;

public class SessionExistException extends RuntimeException{
    public SessionExistException() {
        super(ExceptionConstants.SESSION_NOT_EXIST);
    }
}
