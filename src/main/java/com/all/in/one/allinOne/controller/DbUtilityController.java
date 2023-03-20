package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.service.DbUtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("util")
public class DbUtilityController {

    private final DbUtilityService dbUtilityService;

    @PostMapping("fill")
    public void dbFill() {
        dbUtilityService.dbFill();
    }

}
