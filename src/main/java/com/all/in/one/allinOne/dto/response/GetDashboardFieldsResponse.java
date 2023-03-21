package com.all.in.one.allinOne.dto.response;

import com.all.in.one.allinOne.entity.BanType;
import com.all.in.one.allinOne.entity.Brand;
import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.Colour;
import com.all.in.one.allinOne.entity.Currency;
import com.all.in.one.allinOne.entity.DestinationMeasure;
import com.all.in.one.allinOne.entity.FuelType;
import com.all.in.one.allinOne.entity.GearBoxType;
import com.all.in.one.allinOne.entity.GearType;
import com.all.in.one.allinOne.entity.Model;
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
    private List<Model> models;

}