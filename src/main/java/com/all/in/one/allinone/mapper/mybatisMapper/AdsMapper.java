package com.all.in.one.allinone.mapper.mybatisMapper;


import com.all.in.one.allinone.model.dto.request.GetFilteredAdsRequest;
import com.all.in.one.allinone.model.mybatis.Ads;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdsMapper {

    List<Ads> findAllAdsPageByPage(@Param("limit") Integer limit,
                                   @Param("from") Integer from);

    List<Ads> findAllAdsByFilter(GetFilteredAdsRequest getFilteredAdsRequest);

    Integer findCountOfAdsByAdsLink(@Param("adsLink") String adsLink);

    void insert(Ads ads);

    void deactivate(@Param("adsLink") String adsLink);

}
