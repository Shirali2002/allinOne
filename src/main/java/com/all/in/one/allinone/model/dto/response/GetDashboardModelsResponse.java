package com.all.in.one.allinone.model.dto.response;

import com.all.in.one.allinone.model.mybatis.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetDashboardModelsResponse implements Serializable {

    private List<Model> models;

    public static GetDashboardModelsResponse of(List<Model> models) {
        GetDashboardModelsResponse response = new GetDashboardModelsResponse();
        response.setModels(models);

        return response;
    }

}