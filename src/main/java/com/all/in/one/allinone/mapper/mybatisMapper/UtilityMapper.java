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
public interface UtilityMapper {

    void insertCurrency(Currency currency);
    List<Currency> findAllCurrency();

    void insertBanType(BanType banType);
    List<BanType> findAllBanType();

    void insertBrand(Brand brand);
    List<Brand> findAllBrand();

    void insertCity(City city);
    List<City> findAllCity();

    void insertColour(Colour colour);
    List<Colour> findAllColour();

    void insertDestinationMeasure(DestinationMeasure destinationMeasure);
    List<DestinationMeasure> findAllDestinationMeasure();

    void insertFuelType(FuelType fuelType);
    List<FuelType> findAllFuelType();

    void insertGearBoxType(GearBoxType gearBoxType);
    List<GearBoxType> findAllGearBoxType();

    void insertGearType(GearType gearType);
    List<GearType> findAllGearType();

    void insertModel(Model model);
    List<Model> findAllModel();
    List<Model> findAllModelByBrandCode(@Param("brandCode") Integer brandCode);

}
