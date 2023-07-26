package com.all.in.one.allinone.model.dto.request;

import com.all.in.one.allinone.model.error.ErrorMessages;
import com.all.in.one.allinone.model.error.constraints.Email;
import com.all.in.one.allinone.model.error.constraints.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

@Data
public class ResetPasswordRequest {

    @Email
    private String email;

    @NotNull(message = ErrorMessages.INVALID_OTP_CODE)
    private Integer otpCode;

    @ValidPassword
    private String password;

    @ValidPassword
    private String confirmPassword;

    @JsonIgnore
    public boolean isPasswordMatched() {
        return Objects.equals(password, confirmPassword);
    }

}
