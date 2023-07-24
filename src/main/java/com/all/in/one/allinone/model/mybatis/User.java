package com.all.in.one.allinone.model.mybatis;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class User implements UserDetails {

    private Long id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private Integer otpCode;
    private Boolean enableddd;
    private String resetPasswordToken;
    private String verificationCode;
    private Boolean resetEnabled;

    public String getFullName() {
        return String.format("%s %s", this.name, this.surname);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enableddd;
    }

}