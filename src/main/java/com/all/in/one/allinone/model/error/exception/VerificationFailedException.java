package com.all.in.one.allinone.model.error.exception;

public class VerificationFailedException extends RuntimeException{

    public VerificationFailedException(String errorMessage) {
        super(errorMessage);
    }

}
