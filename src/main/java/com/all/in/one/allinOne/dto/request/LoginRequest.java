package com.all.in.one.allinOne.dto.request;

import com.all.in.one.allinOne.error.ErrorMessages;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank(message = ErrorMessages.INVALID_USERNAME)
    private String username;

    @NotBlank(message = ErrorMessages.INVALID_PASSWORD)
    private String password;

}
