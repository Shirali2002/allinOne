package com.all.in.one.allinone.model.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuelType {

    @JsonIgnore
    private Long id;
    private Integer fuelTypeCode;
    private String name;

}
