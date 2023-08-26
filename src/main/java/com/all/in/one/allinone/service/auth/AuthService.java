package com.all.in.one.allinone.service.auth;

import com.all.in.one.allinone.model.dto.request.LoginRequest;
import com.all.in.one.allinone.model.dto.request.RegisterRequest;
import com.all.in.one.allinone.model.dto.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<AuthenticationResponse> register(RegisterRequest request);

    ResponseEntity<AuthenticationResponse> login(LoginRequest request);

}
