package com.all.in.one.allinOne.dto.request;

import lombok.Data;

@Data
public class VerifyResetPasswordRequest {

    private String email;
    private Integer otp;

}
