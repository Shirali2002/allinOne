package com.all.in.one.allinOne.dto.request;

import com.all.in.one.allinOne.error.ErrorMessages;
import com.all.in.one.allinOne.error.constraints.Email;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VerifyResetPasswordRequest {

    @Email
    private String email;

    @NotNull(message = ErrorMessages.INVALID_OTP_CODE)
    private Integer otp;

}
