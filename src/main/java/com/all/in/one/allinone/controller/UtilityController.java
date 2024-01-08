package com.all.in.one.allinone.controller;

import com.all.in.one.allinone.model.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinone.service.utility.UtilityService;
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

    @GetMapping("dashboard/fields-without-model")
    public GetDashboardFieldsResponse getDashboardFieldsWithoutModels() {
        return utilityService.getDashboardFieldsWithoutModels();
    }

    @GetMapping("dashboard/models")
    public GetDashboardFieldsResponse getDashboardModels() {
        return utilityService.getDashboardModels();
    }

    @GetMapping("dashboard/models/{brandId}")
    public GetDashboardFieldsResponse getDashboardModels(@PathVariable Integer brandId) {
        return utilityService.getDashboardModels(brandId);
    }

}
