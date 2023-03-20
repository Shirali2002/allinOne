package com.all.in.one.allinOne.dto.request;

import com.all.in.one.allinOne.error.constraints.Email;
import lombok.Data;

@Data
public class LoginRequest {

    @Email
    private String username;
    private String password;

}
