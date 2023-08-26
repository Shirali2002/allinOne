package com.all.in.one.allinone.controller;

import com.all.in.one.allinone.model.dto.request.GetFilteredAdsRequest;
import com.all.in.one.allinone.model.error.ErrorMessages;
import com.all.in.one.allinone.model.mybatis.Ads;
import com.all.in.one.allinone.service.ads.AdsService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdsController {

    private final AdsService adsService;

    @GetMapping("/{page}/size/{size}")
    public List<Ads> getAds(@PathVariable @Min(value = 1, message = ErrorMessages.PAGE_MUST_BE_GREATER_THAN_ZERO) Integer page,
                            @PathVariable @Min(value = 1, message = ErrorMessages.SIZE_MUST_BE_GREATER_THAN_ZERO) Integer size) {
        return adsService.getAds(page, size);
    }

    @PostMapping("filter")
    public List<Ads> getFilteredAds(@RequestBody GetFilteredAdsRequest request) {
        return adsService.getFilteredAds(request);
    }

//    @PostMapping("/save")
    public void saveAds(@RequestBody Ads ads) {
        ads.setTtl(LocalDateTime.now(ZoneId.of("Asia/Baku")));
        adsService.saveAds(ads);
    }

    @DeleteMapping
    public void deleteAds(@RequestParam String adsLink) {
        adsService.deleteAds(adsLink);
    }

}