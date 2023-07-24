package com.all.in.one.allinone.service;

import com.all.in.one.allinone.model.dto.request.GetFilteredAdsRequest;
import com.all.in.one.allinone.model.mybatis.Ads;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdsService {
    List<Ads> getAds(Integer page, Integer size);

    List<Ads> getFilteredAds(GetFilteredAdsRequest request);

//    List<Ads> getFilteredAds(GetFilteredAdsRequest request, Integer page, Integer size);

    @Transactional
    void saveAds(Ads ads);

    Integer getCountOfAdsByAdsLink(String adsLink);
}
