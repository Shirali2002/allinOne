package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.dto.Ads;
import com.all.in.one.allinOne.service.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;

    @GetMapping("/{page}")
    public List<Ads> getAds(Integer page) {
        return adsService.getAds(page);
    }

}