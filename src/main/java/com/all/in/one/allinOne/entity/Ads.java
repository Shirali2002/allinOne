package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Ads {

    @JsonIgnore
    private Long id;
    private String adsLink;
    private String imageLink;
    private Integer cityCode;
    private Integer modelCode;
    private Integer year;
    private Integer banTypeCode;
    private Integer colourCode;
    private String enginePower;
    private String engineHorsePower;
    private Integer fuelTypeCode;
    private Long destination;
    private Integer destinationMeasureCode;
    private Integer gearBoxTypeCode;
    private Integer gearTypeCode;
    private Boolean used;
    private Integer numberOfSeats;
    private String price;
    private Integer currencyCode;
    private LocalDateTime ttl;

}
