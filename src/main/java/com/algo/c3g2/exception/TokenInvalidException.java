package com.algo.c3g2.exception;

import com.algo.c3g2.constants.ExceptionConstants;

public class TokenInvalidException extends RuntimeException{

    public TokenInvalidException() {
        super(ExceptionConstants.TOKEN_INVALID);
    }
}
