package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.service.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdsController {

    private final AdsService adsService;

    @GetMapping("/{from}/limit/{limit}")
    public List<Ads> getAds(@PathVariable Integer from, @PathVariable Integer limit) {
        return adsService.getAds(from, limit);
    }

}