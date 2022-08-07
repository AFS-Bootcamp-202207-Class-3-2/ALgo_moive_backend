package com.algo.c3g2.exception;
import static com.algo.c3g2.constants.ExceptionConstants.PASSWORD_WRONG;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(){
        super(PASSWORD_WRONG);
    }
}
