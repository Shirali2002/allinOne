package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.repository.AdsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsService {

    private final AdsRepository adsRepository;

    public List<Ads> getAds(Integer from, Integer limit) {
        return adsRepository.findAllAdsPageByPage(from, limit);
    }

}
