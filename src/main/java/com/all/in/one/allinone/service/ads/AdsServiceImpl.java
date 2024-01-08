package com.all.in.one.allinone.service.ads;

import com.all.in.one.allinone.mapper.mybatisMapper.AdsMapper;
import com.all.in.one.allinone.model.dto.request.GetFilteredAdsRequest;
import com.all.in.one.allinone.model.mybatis.Ads;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdsMapper adsMapper;

    @Override
    @Cacheable(value = "adsPagesCache", key = "{'adsPage' + #page + '-size' + #size}")
    public List<Ads> getAds(Integer page, Integer size) {
        Integer from = size*(page-1);
        return adsMapper.findAllAdsPageByPage(size, from);
    }

    @Override
    @Cacheable(value = "adsFilteredPagesCache", key = "{'filteredPage' + #request.toString()}")
    public List<Ads> getFilteredAds(Integer page, Integer size, GetFilteredAdsRequest request) {
        Integer from = size*(page-1);
        return adsMapper.findAllAdsByFilter(size, from, request);
    }

    @Override
    @Transactional
    public void saveAds(Ads ads) {
        adsMapper.insert(ads);
    }

    @Override
    @Transactional
    public void deleteAds(String adsLink) {
        adsMapper.deactivate(adsLink);
    }

    @Override
    public Integer getCountOfAdsByAdsLink(String adsLink) {
        return adsMapper.findCountOfAdsByAdsLink(adsLink);
    }

}