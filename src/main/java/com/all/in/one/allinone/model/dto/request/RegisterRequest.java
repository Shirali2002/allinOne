package com.all.in.one.allinone.model.dto.request;

import com.all.in.one.allinone.model.error.ErrorMessages;
import com.all.in.one.allinone.model.error.constraints.Email;
import com.all.in.one.allinone.model.error.constraints.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Objects;

@Data
public class RegisterRequest {

    @Email
    private String email;

    @NotBlank(message = ErrorMessages.INVALID_NAME)
    private String name;

    @NotBlank(message = ErrorMessages.INVALID_SURNAME)
    private String surname;

    @ValidPassword
    private String password;

    @ValidPassword
    private String confirmPassword;

    @JsonIgnore
    public boolean isPasswordsMatched() {
        return Objects.nonNull(password) && password.equals(confirmPassword);
    }

}
