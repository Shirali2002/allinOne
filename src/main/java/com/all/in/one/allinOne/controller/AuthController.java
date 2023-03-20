package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.dto.request.RegisterRequest;
import com.all.in.one.allinOne.dto.request.ResetPasswordRequest;
import com.all.in.one.allinOne.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
    }

    @GetMapping("/verify")
    public String verifyUser(@RequestParam("code") String code) {
        return authService.verify(code);
    }

    @GetMapping("/verify/reset-password")
    public String verifyResetPassword(@RequestParam("token") String token) {
        return authService.verifyResetPassword(token);
    }

    @PutMapping("/process/reset-password")
    public void processResetPassword(@RequestParam("email") String email) {
        authService.processResetPassword(email);
    }

    @PutMapping("reset-password")
    public void resetPassword(@RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request);
    }

}