package com.all.in.one.allinOne.dto.request;

import com.all.in.one.allinOne.error.constraints.Email;
import com.all.in.one.allinOne.error.constraints.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

@Data
public class ResetPasswordRequest {

    @Email
    private String email;  //TODO: validation

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
