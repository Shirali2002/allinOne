package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.dto.BanType;
import com.all.in.one.allinOne.dto.City;
import com.all.in.one.allinOne.dto.Colour;
import com.all.in.one.allinOne.dto.Currency;
import com.all.in.one.allinOne.dto.DestinationMeasure;
import com.all.in.one.allinOne.dto.FuelType;
import com.all.in.one.allinOne.dto.GearBoxType;
import com.all.in.one.allinOne.dto.GearType;
import com.all.in.one.allinOne.dto.response.GetDashboardFieldsResponse;
import com.all.in.one.allinOne.dto.response.GetDashboardModelsResponse;
import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.entity.Model;
import com.all.in.one.allinOne.repository.AdsRepository;
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
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
    private final AdsRepository adsRepository;

    @Transactional
    public void dbFill() {
        Arrays.stream(BanType.values())
                .forEach(banType -> {
                    com.all.in.one.allinOne.entity.BanType banTypeEntity = new com.all.in.one.allinOne.entity.BanType();
                    banTypeEntity.setBanTypeCode(banType.getId());
                    banTypeEntity.setName(banType.getValue());
                    banTypeRepository.save(banTypeEntity);
                });

        Arrays.stream(City.values())
                .forEach(city -> {
                    com.all.in.one.allinOne.entity.City cityEntity = new com.all.in.one.allinOne.entity.City();
                    cityEntity.setCityCode(city.getId());
                    cityEntity.setName(city.getValue());
                    cityRepository.save(cityEntity);
                });

        Arrays.stream(Colour.values())
                .forEach(colour -> {
                    com.all.in.one.allinOne.entity.Colour colourEntity = new com.all.in.one.allinOne.entity.Colour();
                    colourEntity.setColourCode(colour.getId());
                    colourEntity.setName(colour.getValue());
                    colourRepository.save(colourEntity);
                });

        Arrays.stream(Currency.values())
                .forEach(currency -> {
                    com.all.in.one.allinOne.entity.Currency currencyEntity = new com.all.in.one.allinOne.entity.Currency();
                    currencyEntity.setCurrencyCode(currency.getId());
                    currencyEntity.setName(currency.getValue());
                    currencyRepository.save(currencyEntity);
                });

        Arrays.stream(DestinationMeasure.values())
                .forEach(dest -> {
                    com.all.in.one.allinOne.entity.DestinationMeasure destEntity = new com.all.in.one.allinOne.entity.DestinationMeasure();
                    destEntity.setDestCode(dest.getId());
                    destEntity.setName(dest.getValue());
                    destinationMeasureRepository.save(destEntity);
                });

        Arrays.stream(FuelType.values())
                .forEach(fuelType -> {
                    com.all.in.one.allinOne.entity.FuelType fuelTypeEntity = new com.all.in.one.allinOne.entity.FuelType();
                    fuelTypeEntity.setFuelTypeCode(fuelType.getId());
                    fuelTypeEntity.setName(fuelType.getValue());
                    fuelTypeRepository.save(fuelTypeEntity);
                });

        Arrays.stream(GearBoxType.values())
                .forEach(gearBoxType -> {
                    com.all.in.one.allinOne.entity.GearBoxType gearBoxTypeEntity = new com.all.in.one.allinOne.entity.GearBoxType();
                    gearBoxTypeEntity.setGearBoxCode(gearBoxType.getId());
                    gearBoxTypeEntity.setName(gearBoxType.getValue());
                    gearBoxTypeRepository.save(gearBoxTypeEntity);
                });

        Arrays.stream(GearType.values())
                .forEach(gearType -> {
                    com.all.in.one.allinOne.entity.GearType gearTypeEntity = new com.all.in.one.allinOne.entity.GearType();
                    gearTypeEntity.setGearTypeCode(gearType.getId());
                    gearTypeEntity.setName(gearType.getValue());
                    gearTypeRepository.save(gearTypeEntity);
                });

    }

    @Transactional
    public void dbFillBrand() {
        saveBrand(9, "Audi");
        saveBrand(-1, "unknown");
//        Arrays.stream(Brand.values())
//                .forEach(brand -> saveBrand(brand.getId(), brand.getValue()));
    }

    public void dbFillAds() {
        Ads ads = new Ads();
        ads.setAdsLink("https://turbo.az/autos/7003473-gaz-next-a21r22-30");
        ads.setImageLink("https://turbo.azstatic.com/uploads/full/2023%2F01%2F13%2F11%2F22%2F11%2F6a85597a-a8c6-4952-982f-4e7dc90ed265%2F8530_fV4txe9wVphwEU05EwFbmw.jpg");
        ads.setCity(cityRepository.findByCityCode(1));
        ads.setModel(modelRepository.findByModelCode(12));
        ads.setYear(2000);
        ads.setBanType(banTypeRepository.findByBanTypeCode(9));
        ads.setColour(colourRepository.findByColourCode(27));
        ads.setEnginePower("3.5 L");
        ads.setEngineHorsePower("150 a.g");
        ads.setFuelType(fuelTypeRepository.findByFuelTypeCode(2));
        ads.setDestination(0L);
        ads.setDestinationMeasure(destinationMeasureRepository.findByDestCode(1));
        ads.setGearBoxType(gearBoxTypeRepository.findByGearBoxCode(1));
        ads.setGearType(gearTypeRepository.findByGearTypeCode(1));
        ads.setUsed(Boolean.FALSE);
        ads.setNumberOfSeats(5);
        ads.setPrice("39000");
        ads.setCurrency(currencyRepository.findByCurrencyCode(1));
        ads.setTtl(LocalDateTime.now());

        adsRepository.save(ads);

    }

    @Transactional
    public void dbFillModel() {
        saveModel(12, "S7", 9);
        saveModel(-1, "unknown", -1);
//        Arrays.stream(Model_A.values())
//                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));
//
//        Arrays.stream(Model_B.values())
//                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));
//
//
//        Arrays.stream(Model_C.values())
//                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));
//
//
//        Arrays.stream(Model_D.values())
//                .forEach(model -> saveModel(model.getModelId(), model.getNick(), model.getBrandId()));


//        com.all.in.one.allinOne.entity.Brand brand = brandRepository.findByCode(9);
//        System.out.println(brand.getCode());
//        System.out.println(brand.getId());
//        System.out.println("-------");
//
//        Model modelEntity = new Model();
//        modelEntity.setModelCode(2452);
//        modelEntity.setName("S7");
//        modelEntity.setBrand(brand);
//
//        modelRepository.save(modelEntity);
//
//        List<Model> all = modelRepository.findAll();
//        System.out.println(all);


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
        GetDashboardFieldsResponse response = new GetDashboardFieldsResponse();
        response.setBanTypes(banTypeRepository.findAll());
        response.setCities(cityRepository.findAll());
        response.setColours(colourRepository.findAll());
        response.setCurrencies(currencyRepository.findAll());
        response.setDestinationMeasures(destinationMeasureRepository.findAll());
        response.setFuelTypes(fuelTypeRepository.findAll());
        response.setGearBoxTypes(gearBoxTypeRepository.findAll());
        response.setGearTypes(gearTypeRepository.findAll());
        response.setBrands(brandRepository.findAll());

        return response;
    }

    public GetDashboardModelsResponse getDashboardModels(Integer brandId) {
        List<Ads> adsList = adsRepository.findAll();
        Ads ads = adsList.get(0);
        com.all.in.one.allinOne.entity.City city = ads.getCity();
        Model model = ads.getModel();
        System.out.println(adsList);
        System.out.println(ads);
        System.out.println(city);
        System.out.println(model);

        List<Model> all = modelRepository.findAll();
        System.out.println(all);

        List<Model> models = modelRepository.findModelByBrand_BrandCode(brandId);
        return GetDashboardModelsResponse.of(models);
    }

    private void saveModel(Integer modelId, String name, Integer brandId) {
        com.all.in.one.allinOne.entity.Brand brand = brandRepository.findByBrandCode(brandId);
        Model modelEntity = new Model();
        modelEntity.setModelCode(modelId);
        modelEntity.setName(name);
        modelEntity.setBrand(brand);
        modelRepository.save(modelEntity);
    }

    private void saveBrand(Integer brandCode, String name) {
        com.all.in.one.allinOne.entity.Brand brandEntity = new com.all.in.one.allinOne.entity.Brand();
        brandEntity.setBrandCode(brandCode);
        brandEntity.setName(name);
        brandRepository.save(brandEntity);
    }
}