package com.all.in.one.allinOne.error.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
