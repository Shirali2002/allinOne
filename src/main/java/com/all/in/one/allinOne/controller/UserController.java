package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/get/{id}")
//    public User findById(@PathVariable String id) {
//        return userService.findById(id);
//    }


}