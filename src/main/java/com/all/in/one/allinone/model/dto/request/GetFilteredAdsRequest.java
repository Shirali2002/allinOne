package com.all.in.one.allinone.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class GetFilteredAdsRequest {

    private Integer brand;
    private List<Integer> model;
    private Boolean used;
    private List<Integer> city;
    private Integer priceMin;
    private Integer priceMax;
    private Integer currency;
    private List<Integer> banType;
    private Integer yearMin;
    private Integer yearMax;
    private List<Integer> colour;
    private List<Integer> fuelType;
    private List<Integer> gearBoxType;
    private List<Integer> gearType;
    private Integer enginePowerMin;
    private Integer enginePowerMax;
    private Integer horsePowerMin;
    private Integer horsePowerMax;
    private Integer destinationMin;
    private Integer destinationMax;
    private Integer destinationMeasure;
    private List<Integer> numberOfSeats;

}
