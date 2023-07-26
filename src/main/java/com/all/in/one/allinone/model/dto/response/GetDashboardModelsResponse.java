package com.all.in.one.allinone.model.dto.response;

import com.all.in.one.allinone.model.mybatis.Model;
import lombok.Data;

import java.util.List;

@Data
public class GetDashboardModelsResponse {

    private List<Model> models;

    public static GetDashboardModelsResponse of(List<Model> models) {
        GetDashboardModelsResponse response = new GetDashboardModelsResponse();
        response.setModels(models);

        return response;
    }

}