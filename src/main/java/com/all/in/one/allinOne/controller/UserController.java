package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.domain.User;
import com.all.in.one.allinOne.dto.request.LoginRequest;
import com.all.in.one.allinOne.dto.request.RegisterUserRequest;
import com.all.in.one.allinOne.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterUserRequest request) {
        userService.register(request);
    }

}