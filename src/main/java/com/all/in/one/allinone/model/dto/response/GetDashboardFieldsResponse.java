package com.all.in.one.allinone.model.dto.response;

import com.all.in.one.allinone.model.mybatis.BanType;
import com.all.in.one.allinone.model.mybatis.Brand;
import com.all.in.one.allinone.model.mybatis.City;
import com.all.in.one.allinone.model.mybatis.Colour;
import com.all.in.one.allinone.model.mybatis.Currency;
import com.all.in.one.allinone.model.mybatis.DestinationMeasure;
import com.all.in.one.allinone.model.mybatis.FuelType;
import com.all.in.one.allinone.model.mybatis.GearBoxType;
import com.all.in.one.allinone.model.mybatis.GearType;
import lombok.Data;

import java.util.List;

@Data
public class GetDashboardFieldsResponse {

    private List<BanType> banTypes;
    private List<City> cities;
    private List<Colour> colours;
    private List<Currency> currencies;
    private List<DestinationMeasure> destinationMeasures;
    private List<FuelType> fuelTypes;
    private List<GearBoxType> gearBoxTypes;
    private List<GearType> gearTypes;
    private List<Brand> brands;

}