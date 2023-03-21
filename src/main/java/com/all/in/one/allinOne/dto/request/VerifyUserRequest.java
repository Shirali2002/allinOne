package com.all.in.one.allinOne.dto.request;

import lombok.Data;

@Data
public class VerifyUserRequest {

    private String email;
    private Integer otpCode;

}
