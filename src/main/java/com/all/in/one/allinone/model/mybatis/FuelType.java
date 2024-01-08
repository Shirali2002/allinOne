package com.all.in.one.allinone.model.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FuelType implements Serializable {

    @JsonIgnore
    private Long id;
    private Integer fuelTypeCode;
    private String name;

}
