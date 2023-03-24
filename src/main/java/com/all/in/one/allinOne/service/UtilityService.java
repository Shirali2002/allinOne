package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinOne.dto.response.GetDashboardModelsResponse;
import com.all.in.one.allinOne.entity.Model;
import com.all.in.one.allinOne.repository.UtilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilityService {

    private final UtilityRepository utilityRepository;

    public GetDashboardFieldsResponse getDashboardFields() {
        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setBanTypes(utilityRepository.findAllBanType());
        response.setCities(utilityRepository.findAllCity());
        response.setColours(utilityRepository.findAllColour());
        response.setCurrencies(utilityRepository.findAllCurrency());
        response.setDestinationMeasures(utilityRepository.findAllDestinationMeasure());
        response.setFuelTypes(utilityRepository.findAllFuelType());
        response.setGearBoxTypes(utilityRepository.findAllGearBoxType());
        response.setGearTypes(utilityRepository.findAllGearType());
        response.setBrands(utilityRepository.findAllBrand());

        return response;
    }

    public GetDashboardModelsResponse getDashboardModels(Integer brandCode) {
        List<Model> models = utilityRepository.findAllModelByBrandCode(brandCode);
        return GetDashboardModelsResponse.of(models);
    }

    public GetDashboardModelsResponse getDashboardModels() {
        List<Model> models = utilityRepository.findAllModel();
        return GetDashboardModelsResponse.of(models);
    }

}