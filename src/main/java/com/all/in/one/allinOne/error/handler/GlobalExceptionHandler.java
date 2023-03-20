package com.all.in.one.allinOne.error.handler;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation problem");
        if (CollectionUtils.isNotEmpty(ex.getBindingResult().getAllErrors())) {
            ex.getBindingResult().getAllErrors().forEach(
                    error -> {
                        String fieldName = error.getObjectName();
                        String errorText = error.getDefaultMessage();
                        errorMessage.addValidationError(fieldName, errorText);
                    });
        }
        return ResponseEntity.unprocessableEntity().body(errorMessage);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorText = ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorText = "Internal Server Error";
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorMessage> handleUnsupportedOperationException() {
        String errorText = "unsupported operation";
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    } //TODO: exception handlers

}