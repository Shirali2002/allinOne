package com.all.in.one.allinone.service.impl;

import com.all.in.one.allinone.mapper.mybatisMapper.UtilityMapper;
import com.all.in.one.allinone.model.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinone.model.dto.response.GetDashboardModelsResponse;
import com.all.in.one.allinone.model.enums.turboAzEnums.BanType;
import com.all.in.one.allinone.model.enums.turboAzEnums.Brand;
import com.all.in.one.allinone.model.enums.turboAzEnums.City;
import com.all.in.one.allinone.model.enums.turboAzEnums.Colour;
import com.all.in.one.allinone.model.enums.turboAzEnums.Currency;
import com.all.in.one.allinone.model.enums.turboAzEnums.DestinationMeasure;
import com.all.in.one.allinone.model.enums.turboAzEnums.FuelType;
import com.all.in.one.allinone.model.enums.turboAzEnums.GearBoxType;
import com.all.in.one.allinone.model.enums.turboAzEnums.GearType;
import com.all.in.one.allinone.model.enums.turboAzEnums.Model_A;
import com.all.in.one.allinone.model.enums.turboAzEnums.Model_B;
import com.all.in.one.allinone.model.enums.turboAzEnums.Model_C;
import com.all.in.one.allinone.model.enums.turboAzEnums.Model_D;
import com.all.in.one.allinone.model.mybatis.Ads;
import com.all.in.one.allinone.model.mybatis.Model;
import com.all.in.one.allinone.model.mybatis.User;
import com.all.in.one.allinone.service.AdsService;
import com.all.in.one.allinone.service.UtilityService;
import com.all.in.one.allinone.util.EmailProvider;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilityServiceImpl implements UtilityService {

    private final AdsService adsService;
    private final UtilityMapper utilityMapper;
    private final EmailProvider emailProvider;

    @Override
    @Transactional
    public void dbFill() {
        Arrays.stream(BanType.values())
                .forEach(banType -> {
                    com.all.in.one.allinone.model.mybatis.BanType banTypeEntity = new com.all.in.one.allinone.model.mybatis.BanType();
                    banTypeEntity.setBanTypeCode(banType.getId());
                    banTypeEntity.setName(banType.getValue());
                    utilityMapper.insertBanType(banTypeEntity);
                });

        Arrays.stream(City.values())
                .forEach(city -> {
                    com.all.in.one.allinone.model.mybatis.City cityEntity = new com.all.in.one.allinone.model.mybatis.City();
                    cityEntity.setCityCode(city.getId());
                    cityEntity.setName(city.getValue());
                    utilityMapper.insertCity(cityEntity);
                });

        Arrays.stream(Colour.values())
                .forEach(colour -> {
                    com.all.in.one.allinone.model.mybatis.Colour colourEntity = new com.all.in.one.allinone.model.mybatis.Colour();
                    colourEntity.setColourCode(colour.getId());
                    colourEntity.setName(colour.getValue());
                    utilityMapper.insertColour(colourEntity);
                });

        Arrays.stream(Currency.values())
                .forEach(currency -> {
                    com.all.in.one.allinone.model.mybatis.Currency currencyEntity = new com.all.in.one.allinone.model.mybatis.Currency();
                    currencyEntity.setCurrencyCode(currency.getId());
                    currencyEntity.setName(currency.getValue());
                    utilityMapper.insertCurrency(currencyEntity);
                });

        Arrays.stream(DestinationMeasure.values())
                .forEach(dest -> {
                    com.all.in.one.allinone.model.mybatis.DestinationMeasure destEntity = new com.all.in.one.allinone.model.mybatis.DestinationMeasure();
                    destEntity.setDestCode(dest.getId());
                    destEntity.setName(dest.getValue());
                    utilityMapper.insertDestinationMeasure(destEntity);
                });

        Arrays.stream(FuelType.values())
                .forEach(fuelType -> {
                    com.all.in.one.allinone.model.mybatis.FuelType fuelTypeEntity = new com.all.in.one.allinone.model.mybatis.FuelType();
                    fuelTypeEntity.setFuelTypeCode(fuelType.getId());
                    fuelTypeEntity.setName(fuelType.getValue());
                    utilityMapper.insertFuelType(fuelTypeEntity);
                });

        Arrays.stream(GearBoxType.values())
                .forEach(gearBoxType -> {
                    com.all.in.one.allinone.model.mybatis.GearBoxType gearBoxTypeEntity = new com.all.in.one.allinone.model.mybatis.GearBoxType();
                    gearBoxTypeEntity.setGearBoxCode(gearBoxType.getId());
                    gearBoxTypeEntity.setName(gearBoxType.getValue());
                    utilityMapper.insertGearBoxType(gearBoxTypeEntity);
                });

        Arrays.stream(GearType.values())
                .forEach(gearType -> {
                    com.all.in.one.allinone.model.mybatis.GearType gearTypeEntity = new com.all.in.one.allinone.model.mybatis.GearType();
                    gearTypeEntity.setGearTypeCode(gearType.getId());
                    gearTypeEntity.setName(gearType.getValue());
                    utilityMapper.insertGearType(gearTypeEntity);
                });

    }

    @Override
    @Transactional
    public void dbFillBrand() {
        Arrays.stream(Brand.values())
                .forEach(brand -> saveBrand(brand.getId(), brand.getValue()));
    }

    @Override
    @Transactional
    public void dbFillAds() {
        Ads ads = new Ads();
        ads.setAdsLink("https://turbo.az/autos/7325893-mercedes-e-200");
        ads.setImageLink("https://turbo.azstatic.com/uploads/full/2023%2F04%2F24%2F16%2F27%2F46%2Fcd6715d1-d4c0-4691-a32d-f00ce8a0eace%2F52799_Q19cKx4vPCAP2GH_H463ZA.jpg");
        ads.setCity("Bakı");
        ads.setModel("E 200");
        ads.setBrand("Mercedes");
        ads.setYear(1995);
        ads.setBanType("Sedan");
        ads.setColour("Gümüşü");
        ads.setEnginePower(2000);
        ads.setEngineHorsePower(136);
        ads.setFuelType("Benzin");
        ads.setDestination(482000);
        ads.setDestinationMeasure("km");
        ads.setGearBoxType("Mexaniki");
        ads.setGearType("Tam");
        ads.setUsed(Boolean.TRUE);
        ads.setPrice(39000);
        ads.setCurrency("AZN");
        ads.setTtl(LocalDateTime.now());

        adsService.saveAds(ads);

    }

    @Override
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

    @Override
    @Cacheable(value = "dashboardFieldsCache", key = "{'dashboardFields'}")
    public GetDashboardFieldsResponse getDashboardFields() {
        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setBanTypes(utilityMapper.findAllBanType());
        response.setCities(utilityMapper.findAllCity());
        response.setColours(utilityMapper.findAllColour());
        response.setCurrencies(utilityMapper.findAllCurrency());
        response.setDestinationMeasures(utilityMapper.findAllDestinationMeasure());
        response.setFuelTypes(utilityMapper.findAllFuelType());
        response.setGearBoxTypes(utilityMapper.findAllGearBoxType());
        response.setGearTypes(utilityMapper.findAllGearType());
        response.setBrands(utilityMapper.findAllBrand());

        return response;
    }

    @Override
    @Cacheable(value = "dashboardModelsCache", key = "{'dashboardModels'}")
    public GetDashboardModelsResponse getDashboardModels() {
        List<Model> models = utilityMapper.findAllModel();
        return GetDashboardModelsResponse.of(models);
    }

    @Override
    public GetDashboardModelsResponse getDashboardModels(Integer brandCode) {
        List<Model> models = utilityMapper.findAllModelByBrandCode(brandCode);
        return GetDashboardModelsResponse.of(models);
    }

    @Override
    public void sendRegistrationOtpMail(String email, String name, String surname, Integer otpCode) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setOtpCode(otpCode);

        try {
            emailProvider.sendRegistrationOtp(user);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveModel(Integer modelId, String name, Integer brandCode) {
        Model modelEntity = new Model();
        modelEntity.setModelCode(modelId);
        modelEntity.setName(name);
        modelEntity.setBrandCode(brandCode);
        utilityMapper.insertModel(modelEntity);
    }

    private void saveBrand(Integer brandCode, String name) {
        com.all.in.one.allinone.model.mybatis.Brand brandEntity = new com.all.in.one.allinone.model.mybatis.Brand();
        brandEntity.setBrandCode(brandCode);
        brandEntity.setName(name);
        utilityMapper.insertBrand(brandEntity);
    }

}