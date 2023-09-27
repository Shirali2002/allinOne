package com.all.in.one.allinone.service.ads;

import com.all.in.one.allinone.model.dto.request.GetFilteredAdsRequest;
import com.all.in.one.allinone.model.mybatis.Ads;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdsService {
    List<Ads> getAds(Integer page, Integer size);

//    @Cacheable(value = "adsFilteredPagesCache", key = "{'filteredPage' + #request.toString()}")
    List<Ads> getFilteredAds(Integer page, Integer size, GetFilteredAdsRequest request);

    @Transactional
    void saveAds(Ads ads);

    @Transactional
    void deleteAds(String adsLink);

    Integer getCountOfAdsByAdsLink(String adsLink);
}
