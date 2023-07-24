package com.all.in.one.allinone.model.dto.request;

import com.all.in.one.allinone.model.error.ErrorMessages;
import com.all.in.one.allinone.model.error.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VerifyUserRequest {

    @Email
    private String email;

    @NotNull(message = ErrorMessages.INVALID_OTP_CODE)
    private Integer otpCode;

}
