package com.all.in.one.allinOne.error.handler;

import com.all.in.one.allinOne.error.exception.DuplicateUsernameException;
import com.all.in.one.allinOne.error.exception.EmailProviderException;
import com.all.in.one.allinOne.error.exception.PasswordsNotMatchedException;
import com.all.in.one.allinOne.error.exception.UserNotEnabledException;
import com.all.in.one.allinOne.error.exception.UserNotFoundException;
import com.all.in.one.allinOne.error.exception.VerificationFailedException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorMessage errorMessage = new ErrorMessage("Validation problem");
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
        ErrorMessage errorMessage = new ErrorMessage(errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorText = "Internal Server Error";
        ErrorMessage errorMessage = new ErrorMessage(errorText);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorMessage);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorMessage> handleUnsupportedOperationException() {
        String errorText = "unsupported operation";
        ErrorMessage errorMessage = new ErrorMessage(errorText);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value()).body(errorMessage);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED.value()).body(errorMessage);
    }

    @ExceptionHandler(UserNotEnabledException.class)
    public ResponseEntity<ErrorMessage> handleUserNotEnabledException(UserNotEnabledException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value()).body(errorMessage);
    }

    @ExceptionHandler(PasswordsNotMatchedException.class)
    public ResponseEntity<ErrorMessage> handlePasswordsNotMatchedException(PasswordsNotMatchedException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value()).body(errorMessage);
    }

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<ErrorMessage> handleDuplicateUsernameException(DuplicateUsernameException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT.value()).body(errorMessage);
    }

    @ExceptionHandler(EmailProviderException.class)
    public ResponseEntity<ErrorMessage> handleEmailProviderException(EmailProviderException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(errorMessage);
    }

    @ExceptionHandler(VerificationFailedException.class)
    public ResponseEntity<ErrorMessage> handleVerificationFailedException(VerificationFailedException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.GONE.value()).body(errorMessage);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED.value()).body(errorMessage);
    }

}