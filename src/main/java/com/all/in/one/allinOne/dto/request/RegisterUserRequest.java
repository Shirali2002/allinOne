package com.all.in.one.allinOne.dto.request;

import com.all.in.one.allinOne.error.ErrorMessages;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterUserRequest {

    @NotBlank(message = ErrorMessages.INVALID_USERNAME)
    private String username;

    @NotBlank(message = ErrorMessages.INVALID_NAME)
    private String name;

    @NotBlank(message = ErrorMessages.INVALID_SURNAME)
    private String surname;

    @NotBlank(message = ErrorMessages.INVALID_PASSWORD)
    private String password;

}