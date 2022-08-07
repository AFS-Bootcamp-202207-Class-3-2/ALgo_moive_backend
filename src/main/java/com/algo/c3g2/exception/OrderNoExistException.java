package com.algo.c3g2.exception;

import com.algo.c3g2.constants.ExceptionConstants;

public class OrderNoExistException extends RuntimeException{
    public OrderNoExistException() {
        super(ExceptionConstants.ORDER_NOT_EXIST);
    }
}
