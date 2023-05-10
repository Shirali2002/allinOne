package com.all.in.one.allinOne.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Ads {

    private String adsLink;
    private String imageLink;
    private Integer destination;
    private Integer enginePower;
    private Integer engineHorsePower;
    private Integer numberOfSeats;
    private Integer price;
    private LocalDateTime ttl;
    private Boolean used;
    private Integer year;
    private String banType;
    private String city;
    private String colour;
    private String currency;
    private String destinationMeasure;
    private String fuelType;
    private String gearBoxType;
    private String gearType;
    private String model;
    private String brand;

}
