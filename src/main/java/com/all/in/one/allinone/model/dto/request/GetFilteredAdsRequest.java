package com.all.in.one.allinone.model.dto.request;

import lombok.Data;

@Data
public class GetFilteredAdsRequest {

    private Integer brand;
    private Integer model;
    private Boolean used;
    private Integer city;
    private Integer priceMin;
    private Integer priceMax;
    private Integer currency;
    private Integer banType;
    private Integer yearMin;
    private Integer yearMax;
    private Integer colour;
    private Integer fuelType;
    private Integer gearBoxType;
    private Integer gearType;
    private Integer enginePowerMin;
    private Integer enginePowerMax;
    private Integer horsePowerMin;
    private Integer horsePowerMax;
    private Integer destinationMin;
    private Integer destinationMax;
    private Integer destinationMeasure;
    private Integer numberOfSeats;

    private Integer page;
    private Integer size;

}
