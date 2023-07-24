package com.all.in.one.allinone.service;

import com.all.in.one.allinone.model.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinone.model.dto.response.GetDashboardModelsResponse;
import org.springframework.transaction.annotation.Transactional;

public interface UtilityService {
    @Transactional
    void dbFill();

    @Transactional
    void dbFillBrand();

    @Transactional
    void dbFillAds();

    @Transactional
    void dbFillModel();

    GetDashboardFieldsResponse getDashboardFields();

    GetDashboardModelsResponse getDashboardModels();

    GetDashboardModelsResponse getDashboardModels(Integer brandCode);
}
