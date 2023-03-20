package com.all.in.one.allinOne.error.exception;

public class PasswordsNotMatchedException extends RuntimeException {

    public PasswordsNotMatchedException(String errorMessage) {
        super(errorMessage);
    }

}
