package com.all.in.one.allinone.controller;

import com.all.in.one.allinone.model.dto.request.FillDbRequest;
import com.all.in.one.allinone.service.admin.AdminBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    private final AdminBusinessService adminBusinessService;

    @PutMapping("fill-db")
    public void fillDb(FillDbRequest fillDbRequest) {
        adminBusinessService.fillDb(fillDbRequest);
    }

}
