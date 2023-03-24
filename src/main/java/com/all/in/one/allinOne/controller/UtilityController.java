package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinOne.dto.response.GetDashboardModelsResponse;
import com.all.in.one.allinOne.service.UtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("util")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UtilityController {

    private final UtilityService utilityService;

    @GetMapping("dashboard/fields")
    public GetDashboardFieldsResponse getDashboardFields() {
        return utilityService.getDashboardFields();
    }

    @GetMapping("dashboard/models/{brandId}")
    public GetDashboardModelsResponse getDashboardModels(@PathVariable Integer brandId) {
        return utilityService.getDashboardModels(brandId);
    }

    @GetMapping("dashboard/models")
    public GetDashboardModelsResponse getDashboardModels() {
        return utilityService.getDashboardModels();
    }

}
