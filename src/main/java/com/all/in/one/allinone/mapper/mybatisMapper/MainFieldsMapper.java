package com.all.in.one.allinone.mapper.mybatisMapper;


import com.all.in.one.allinone.model.mybatis.BanType;
import com.all.in.one.allinone.model.mybatis.Brand;
import com.all.in.one.allinone.model.mybatis.City;
import com.all.in.one.allinone.model.mybatis.Colour;
import com.all.in.one.allinone.model.mybatis.Currency;
import com.all.in.one.allinone.model.mybatis.DestinationMeasure;
import com.all.in.one.allinone.model.mybatis.FuelType;
import com.all.in.one.allinone.model.mybatis.GearBoxType;
import com.all.in.one.allinone.model.mybatis.GearType;
import com.all.in.one.allinone.model.mybatis.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainFieldsMapper {

    void insertCurrency(Currency currency);
    void insertCurrencies(List<Currency> currencies);
    void truncateCurrencies();
    List<Currency> findAllCurrency();

    void insertBanType(BanType banType);
    void insertBanTypes(List<BanType> banTypes);
    void truncateBanTypes();
    List<BanType> findAllBanType();

    void insertBrand(Brand brand);
    void insertBrands(List<Brand> brands);
    void truncateBrands();
    List<Brand> findAllBrand();

    void insertCity(City city);
    void insertCities(List<City> cities);
    void truncateCities();
    List<City> findAllCity();

    void insertColour(Colour colour);
    void insertColours(List<Colour> colours);
    void truncateColours();
    List<Colour> findAllColour();

    void insertDestinationMeasure(DestinationMeasure destinationMeasure);
    void insertDestinationMeasures(List<DestinationMeasure> destinationMeasures);
    void truncateDestinationMeasures();
    List<DestinationMeasure> findAllDestinationMeasure();

    void insertFuelType(FuelType fuelType);
    void insertFuelTypes(List<FuelType> fuelTypes);
    void truncateFuelTypes();
    List<FuelType> findAllFuelType();

    void insertGearBoxType(GearBoxType gearBoxType);
    void insertGearBoxTypes(List<GearBoxType> gearBoxTypes);
    void truncateGearBoxTypes();
    List<GearBoxType> findAllGearBoxType();

    void insertGearType(GearType gearType);
    void insertGearTypes(List<GearType> gearTypes);
    void truncateGearTypes();
    List<GearType> findAllGearType();

    void insertModel(Model model);
    void insertModels(List<Model> models);
    void truncateModels();
    List<Model> findAllModel();
    List<Model> findAllModelByBrandCode(@Param("brandCode") Integer brandCode);

}
