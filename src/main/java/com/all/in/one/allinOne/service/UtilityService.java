package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.dto.BanType;
import com.all.in.one.allinOne.dto.Brand;
import com.all.in.one.allinOne.dto.City;
import com.all.in.one.allinOne.dto.Colour;
import com.all.in.one.allinOne.dto.Currency;
import com.all.in.one.allinOne.dto.DestinationMeasure;
import com.all.in.one.allinOne.dto.FuelType;
import com.all.in.one.allinOne.dto.GearBoxType;
import com.all.in.one.allinOne.dto.GearType;
import com.all.in.one.allinOne.dto.Model_A;
import com.all.in.one.allinOne.dto.Model_B;
import com.all.in.one.allinOne.dto.Model_C;
import com.all.in.one.allinOne.dto.Model_D;
import com.all.in.one.allinOne.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinOne.dto.response.GetDashboardModelsResponse;
import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.entity.Model;
import com.all.in.one.allinOne.repository.AdsRepository;
import com.all.in.one.allinOne.repository.UtilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilityService {

    private final AdsService adsService;
    private final UtilityRepository utilityRepository;

    @Transactional
    public void dbFill() {
        Arrays.stream(BanType.values())
                .forEach(banType -> {
                    com.all.in.one.allinOne.entity.BanType banTypeEntity = new com.all.in.one.allinOne.entity.BanType();
                    banTypeEntity.setBanTypeCode(banType.getId());
                    banTypeEntity.setName(banType.getValue());
                    utilityRepository.saveBanType(banTypeEntity);
                });

        Arrays.stream(City.values())
                .forEach(city -> {
                    com.all.in.one.allinOne.entity.City cityEntity = new com.all.in.one.allinOne.entity.City();
                    cityEntity.setCityCode(city.getId());
                    cityEntity.setName(city.getValue());
                    utilityRepository.saveCity(cityEntity);
                });

        Arrays.stream(Colour.values())
                .forEach(colour -> {
                    com.all.in.one.allinOne.entity.Colour colourEntity = new com.all.in.one.allinOne.entity.Colour();
                    colourEntity.setColourCode(colour.getId());
                    colourEntity.setName(colour.getValue());
                    utilityRepository.saveColour(colourEntity);
                });

        Arrays.stream(Currency.values())
                .forEach(currency -> {
                    com.all.in.one.allinOne.entity.Currency currencyEntity = new com.all.in.one.allinOne.entity.Currency();
                    currencyEntity.setCurrencyCode(currency.getId());
                    currencyEntity.setName(currency.getValue());
                    utilityRepository.saveCurrency(currencyEntity);
                });

        Arrays.stream(DestinationMeasure.values())
                .forEach(dest -> {
                    com.all.in.one.allinOne.entity.DestinationMeasure destEntity = new com.all.in.one.allinOne.entity.DestinationMeasure();
                    destEntity.setDestCode(dest.getId());
                    destEntity.setName(dest.getValue());
                    utilityRepository.saveDestinationMeasure(destEntity);
                });

        Arrays.stream(FuelType.values())
                .forEach(fuelType -> {
                    com.all.in.one.allinOne.entity.FuelType fuelTypeEntity = new com.all.in.one.allinOne.entity.FuelType();
                    fuelTypeEntity.setFuelTypeCode(fuelType.getId());
                    fuelTypeEntity.setName(fuelType.getValue());
                    utilityRepository.saveFuelType(fuelTypeEntity);
                });

        Arrays.stream(GearBoxType.values())
                .forEach(gearBoxType -> {
                    com.all.in.one.allinOne.entity.GearBoxType gearBoxTypeEntity = new com.all.in.one.allinOne.entity.GearBoxType();
                    gearBoxTypeEntity.setGearBoxCode(gearBoxType.getId());
                    gearBoxTypeEntity.setName(gearBoxType.getValue());
                    utilityRepository.saveGearBoxType(gearBoxTypeEntity);
                });

        Arrays.stream(GearType.values())
                .forEach(gearType -> {
                    com.all.in.one.allinOne.entity.GearType gearTypeEntity = new com.all.in.one.allinOne.entity.GearType();
                    gearTypeEntity.setGearTypeCode(gearType.getId());
                    gearTypeEntity.setName(gearType.getValue());
                    utilityRepository.saveGearType(gearTypeEntity);
                });

    }

    @Transactional
    public void dbFillBrand() {
        Arrays.stream(Brand.values())
                .forEach(brand -> saveBrand(brand.getId(), brand.getValue()));
    }

    @Transactional
    public void dbFillAds() {
//        Ads ads = new Ads();
//        ads.setAdsLink("https://turbo.az/autos/7325893-mercedes-e-200");
//        ads.setImageLink("https://turbo.azstatic.com/uploads/full/2023%2F04%2F24%2F16%2F27%2F46%2Fcd6715d1-d4c0-4691-a32d-f00ce8a0eace%2F52799_Q19cKx4vPCAP2GH_H463ZA.jpg");
//        ads.setCity("Bakı");
//        ads.setModel("E 200");
//        ads.setBrand("Mercedes");
//        ads.setYear(1995);
//        ads.setBanType("Sedan");
//        ads.setColour("Gümüşü");
//        ads.setEnginePower("2.0 L");
//        ads.setEngineHorsePower("136 a.g");
//        ads.setFuelType("Benzin");
//        ads.setDestination("482 000");
//        ads.setDestinationMeasure("km");
//        ads.setGearBoxType("Mexaniki");
//        ads.setGearType("Tam");
//        ads.setUsed(Boolean.TRUE);
//        ads.setPrice(39000);
//        ads.setCurrency("AZN");
//        ads.setTtl(LocalDateTime.now());
//
//        adsService.saveAds(ads);

    }

    @Transactional
    public void dbFillModel() {
        Arrays.stream(Model_A.values())
                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));

        Arrays.stream(Model_B.values())
                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));

        Arrays.stream(Model_C.values())
                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));

        Arrays.stream(Model_D.values())
                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));

    }

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

    public GetDashboardModelsResponse getDashboardModels() {
        List<Model> models = utilityRepository.findAllModel();
        return GetDashboardModelsResponse.of(models);
    }

    public GetDashboardModelsResponse getDashboardModels(Integer brandCode) {
        List<Model> models = utilityRepository.findAllModelByBrandCode(brandCode);
        return GetDashboardModelsResponse.of(models);
    }

    private void saveModel(Integer modelId, String name, Integer brandCode) {
        Model modelEntity = new Model();
        modelEntity.setModelCode(modelId);
        modelEntity.setName(name);
        modelEntity.setBrandCode(brandCode);
        utilityRepository.saveModel(modelEntity);
    }

    private void saveBrand(Integer brandCode, String name) {
        com.all.in.one.allinOne.entity.Brand brandEntity = new com.all.in.one.allinOne.entity.Brand();
        brandEntity.setBrandCode(brandCode);
        brandEntity.setName(name);
        utilityRepository.saveBrand(brandEntity);
    }

}