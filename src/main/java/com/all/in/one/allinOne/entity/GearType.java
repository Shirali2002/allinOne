package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GearType {

    @JsonIgnore
    private Long id;
    private Integer gearTypeCode;
    private String name;

}
