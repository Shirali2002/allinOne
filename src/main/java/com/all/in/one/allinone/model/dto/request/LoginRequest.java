package com.all.in.one.allinone.model.dto.request;

import com.all.in.one.allinone.model.error.constraints.Email;
import lombok.Data;

@Data
public class LoginRequest {

    @Email
    private String username;
    private String password;

}
