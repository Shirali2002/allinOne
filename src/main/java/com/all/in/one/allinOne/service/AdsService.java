package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.repository.AdsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsService {

    private final AdsRepository adsRepository;

    public List<Ads> getAds(Integer page, Integer size) {
        Integer from = size*(page-1);
        return adsRepository.findAllAdsPageByPage(from, size);
    }

    @Transactional
    public void saveAds(Ads ads) {
        adsRepository.saveAds(ads);
    }

    public Integer getCountOfAdsByAdsLink(String adsLink) {
        return adsRepository.findCountOfAdsByAdsLink(adsLink);
    }

}
