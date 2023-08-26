package com.all.in.one.allinone.service.utility;

import com.all.in.one.allinone.model.dto.response.GetDashboardFieldsResponse;

public interface UtilityService {

    GetDashboardFieldsResponse getDashboardFields();

    GetDashboardFieldsResponse getDashboardFieldsWithoutModels();

    GetDashboardFieldsResponse getDashboardModels();

    GetDashboardFieldsResponse getDashboardModels(Integer brandCode);

}
