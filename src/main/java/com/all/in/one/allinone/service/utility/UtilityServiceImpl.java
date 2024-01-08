package com.all.in.one.allinone.service.utility;

import com.all.in.one.allinone.mapper.mybatisMapper.MainFieldsMapper;
import com.all.in.one.allinone.model.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinone.model.mybatis.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilityServiceImpl implements UtilityService {

    private final MainFieldsMapper mainFieldsMapper;

    @Override
    @Cacheable(value = "dashboardFieldsCache", key = "{'dashboardFields'}")
    public GetDashboardFieldsResponse getDashboardFields() {
        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setBanTypes(mainFieldsMapper.findAllBanType());
        response.setCities(mainFieldsMapper.findAllCity());
        response.setColours(mainFieldsMapper.findAllColour());
        response.setCurrencies(mainFieldsMapper.findAllCurrency());
        response.setDestinationMeasures(mainFieldsMapper.findAllDestinationMeasure());
        response.setFuelTypes(mainFieldsMapper.findAllFuelType());
        response.setGearBoxTypes(mainFieldsMapper.findAllGearBoxType());
        response.setGearTypes(mainFieldsMapper.findAllGearType());
        response.setBrands(mainFieldsMapper.findAllBrand());

        return response;
    }

    @Override
    @Cacheable(value = "dashboardModelsCache", key = "{'dashboardModels'}")
    public GetDashboardFieldsResponse getDashboardFieldsWithoutModels() {
        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setBanTypes(mainFieldsMapper.findAllBanType());
        response.setCities(mainFieldsMapper.findAllCity());
        response.setColours(mainFieldsMapper.findAllColour());
        response.setCurrencies(mainFieldsMapper.findAllCurrency());
        response.setDestinationMeasures(mainFieldsMapper.findAllDestinationMeasure());
        response.setFuelTypes(mainFieldsMapper.findAllFuelType());
        response.setGearBoxTypes(mainFieldsMapper.findAllGearBoxType());
        response.setGearTypes(mainFieldsMapper.findAllGearType());
        response.setBrands(mainFieldsMapper.findAllBrand());
        response.setModels(mainFieldsMapper.findAllModel());

        return response;
    }

    @Override
    public GetDashboardFieldsResponse getDashboardModels() {
        List<Model> models = mainFieldsMapper.findAllModel();

        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setModels(models);

        return response;
    }

    @Override
    public GetDashboardFieldsResponse getDashboardModels(Integer brandCode) {
        List<Model> models = mainFieldsMapper.findAllModelByBrandCode(brandCode);

        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setModels(models);

        return response;    }

}