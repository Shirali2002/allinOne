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
import com.all.in.one.allinOne.dto.Model_E;
import com.all.in.one.allinOne.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinOne.entity.Model;
import com.all.in.one.allinOne.repository.BanTypeRepository;
import com.all.in.one.allinOne.repository.BrandRepository;
import com.all.in.one.allinOne.repository.CityRepository;
import com.all.in.one.allinOne.repository.ColourRepository;
import com.all.in.one.allinOne.repository.CurrencyRepository;
import com.all.in.one.allinOne.repository.DestinationMeasureRepository;
import com.all.in.one.allinOne.repository.FuelTypeRepository;
import com.all.in.one.allinOne.repository.GearBoxTypeRepository;
import com.all.in.one.allinOne.repository.GearTypeRepository;
import com.all.in.one.allinOne.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UtilityService {

    private final BanTypeRepository banTypeRepository;
    private final BrandRepository brandRepository;
    private final CityRepository cityRepository;
    private final ColourRepository colourRepository;
    private final CurrencyRepository currencyRepository;
    private final DestinationMeasureRepository destinationMeasureRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final GearBoxTypeRepository gearBoxTypeRepository;
    private final GearTypeRepository gearTypeRepository;
    private final ModelRepository modelRepository;

    @Transactional
    public void dbFill() {
        Arrays.stream(BanType.values())
                .forEach(banType -> {
                    com.all.in.one.allinOne.entity.BanType banTypeEntity = new com.all.in.one.allinOne.entity.BanType();
                    banTypeEntity.setId(banType.getId());
                    banTypeEntity.setName(banType.getValue());
                    banTypeRepository.save(banTypeEntity);
                });

        Arrays.stream(City.values())
                .forEach(city -> {
                    com.all.in.one.allinOne.entity.City cityEntity = new com.all.in.one.allinOne.entity.City();
                    cityEntity.setId(city.getId());
                    cityEntity.setName(city.getValue());
                    cityRepository.save(cityEntity);
                });

        Arrays.stream(Colour.values())
                .forEach(colour -> {
                    com.all.in.one.allinOne.entity.Colour colourEntity = new com.all.in.one.allinOne.entity.Colour();
                    colourEntity.setId(colour.getId());
                    colourEntity.setName(colour.getValue());
                    colourRepository.save(colourEntity);
                });

        Arrays.stream(Currency.values())
                .forEach(currency -> {
                    com.all.in.one.allinOne.entity.Currency currencyEntity = new com.all.in.one.allinOne.entity.Currency();
                    currencyEntity.setId(currency.getId());
                    currencyEntity.setName(currency.getValue());
                    currencyRepository.save(currencyEntity);
                });

        Arrays.stream(DestinationMeasure.values())
                .forEach(dest -> {
                    com.all.in.one.allinOne.entity.DestinationMeasure destEntity = new com.all.in.one.allinOne.entity.DestinationMeasure();
                    destEntity.setId(dest.getId());
                    destEntity.setName(dest.getValue());
                    destinationMeasureRepository.save(destEntity);
                });

        Arrays.stream(FuelType.values())
                .forEach(fuelType -> {
                    com.all.in.one.allinOne.entity.FuelType fuelTypeEntity = new com.all.in.one.allinOne.entity.FuelType();
                    fuelTypeEntity.setId(fuelType.getId());
                    fuelTypeEntity.setName(fuelType.getValue());
                    fuelTypeRepository.save(fuelTypeEntity);
                });

        Arrays.stream(GearBoxType.values())
                .forEach(gearBoxType -> {
                    com.all.in.one.allinOne.entity.GearBoxType gearBoxTypeEntity = new com.all.in.one.allinOne.entity.GearBoxType();
                    gearBoxTypeEntity.setId(gearBoxType.getId());
                    gearBoxTypeEntity.setName(gearBoxType.getValue());
                    gearBoxTypeRepository.save(gearBoxTypeEntity);
                });

        Arrays.stream(GearType.values())
                .forEach(gearType -> {
                    com.all.in.one.allinOne.entity.GearType gearTypeEntity = new com.all.in.one.allinOne.entity.GearType();
                    gearTypeEntity.setId(gearType.getId());
                    gearTypeEntity.setName(gearType.getValue());
                    gearTypeRepository.save(gearTypeEntity);
                });

    }

    @Transactional
    public void dbFillBrand() {
        Arrays.stream(Brand.values())
                .forEach(brand -> {
                    com.all.in.one.allinOne.entity.Brand brandEntity = new com.all.in.one.allinOne.entity.Brand();
                    brandEntity.setCode(brand.getId());
                    brandEntity.setName(brand.getValue());
                    brandRepository.save(brandEntity);
                });
    }

    @Transactional
    public void dbFillModel() {
//        Arrays.stream(Model_A.values())
//                .forEach(model -> {
//                    Model modelEntity = new Model();
//                    modelEntity.setId(model.getModelId());
//                    modelEntity.setName(model.getNick());
//                    modelEntity.setBrand(brandRepository.getById(model.getBrandId()));
//                    modelRepository.save(modelEntity);
//                });
//
//        Arrays.stream(Model_B.values())
//                .forEach(model -> {
//                    Model modelEntity = new Model();
//                    modelEntity.setId(model.getModelId());
//                    modelEntity.setName(model.getNick());
//                    modelEntity.setBrand(brandRepository.getById(model.getBrandId()));
//                    modelRepository.save(modelEntity);
//                });
//
//        Arrays.stream(Model_C.values())
//                .forEach(model -> {
//                    Model modelEntity = new Model();
//                    modelEntity.setId(model.getModelId());
//                    modelEntity.setName(model.getNick());
//                    modelEntity.setBrand(brandRepository.getById(model.getBrandId()));
//                    modelRepository.save(modelEntity);
//                });
//
//        Arrays.stream(Model_D.values())
//                .forEach(model -> {
//                    Model modelEntity = new Model();
//                    modelEntity.setId(model.getModelId());
//                    modelEntity.setName(model.getNick());
//                    modelEntity.setBrand(brandRepository.getById(model.getBrandId()));
//                    modelRepository.save(modelEntity);
//                });
//
//        Arrays.stream(Model_E.values())
//                .forEach(model -> {
//                    Model modelEntity = new Model();
//                    modelEntity.setId(model.getModelId());
//                    modelEntity.setName(model.getNick());
//                    com.all.in.one.allinOne.entity.Brand brand = brandRepository.getById(model.getBrandId());
//                    modelEntity.setBrand(brand);
//                    modelRepository.save(modelEntity);
//                });


        com.all.in.one.allinOne.entity.Brand brand = brandRepository.findByCode(9);

        com.all.in.one.allinOne.entity.Brand brandNew = new com.all.in.one.allinOne.entity.Brand();
        brandNew.setCode(brand.getCode());

        Model modelEntity = new Model();
        modelEntity.setModelCode(2452);
        modelEntity.setName("S7");
        modelEntity.setBrand(brandNew);
        modelRepository.save(modelEntity);



//        ArrayList<Model> models = new ArrayList<>();
//        models.add(modelEntity);
//        if (Objects.nonNull(brand)){
//            brand.setModels(models);
//        } else {
//            throw new RuntimeException("null du blet");
//        }
//        brandRepository.save(brand);
//        modelEntity.setBrand(brand);



    }

    public GetDashboardFieldsResponse getDashboardFields() {
        System.out.println(modelRepository.findAll());

//        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
//        response.setBanTypes(banTypeRepository.findAll());
//        response.setCities(cityRepository.findAll());
//        response.setColours(colourRepository.findAll());
//        response.setCurrencies(currencyRepository.findAll());
//        response.setDestinationMeasures(destinationMeasureRepository.findAll());
//        response.setFuelTypes(fuelTypeRepository.findAll());
//        response.setGearBoxTypes(gearBoxTypeRepository.findAll());
//        response.setGearTypes(gearTypeRepository.findAll());
//        response.setBrands(brandRepository.findAll());
//        response.setModels(modelRepository.findAll());
//
//        return response;
        return null;
    }
}