package com.all.in.one.allinone.model.error.exception;

public class PasswordsNotMatchedException extends RuntimeException {

    public PasswordsNotMatchedException(String errorMessage) {
        super(errorMessage);
    }

}
