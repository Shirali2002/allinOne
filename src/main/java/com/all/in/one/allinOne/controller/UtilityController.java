package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinOne.service.UtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("util")
public class UtilityController {

    private final UtilityService utilityService;

    @PostMapping("fill")
    public void dbFill() {
        utilityService.dbFill();
    }

    @PostMapping("fill/model")
    public void dbFillModel() {
        utilityService.dbFillModel();
    }

    @PostMapping("fill/brand")
    public void dbFillBrand() {
        utilityService.dbFillBrand();
    }

    @GetMapping("dashboard/fields")
    public GetDashboardFieldsResponse getDashboardFields() {
        return utilityService.getDashboardFields();
    }

}
