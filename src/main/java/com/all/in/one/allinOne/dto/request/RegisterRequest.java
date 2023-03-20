package com.all.in.one.allinOne.dto.request;

import com.all.in.one.allinOne.error.constraints.Email;
import com.all.in.one.allinOne.error.constraints.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class RegisterRequest {
    @Email
    private String email;
    private String name; //TODO: validations
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
