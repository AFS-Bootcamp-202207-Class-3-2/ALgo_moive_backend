package com.algo.c3g2.exception;

import com.algo.c3g2.constants.ExceptionConstants;

public class NotTokenException extends RuntimeException{

    public NotTokenException() {
        super(ExceptionConstants.NOT_TOKEN);
    }
}
