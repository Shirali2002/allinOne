package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Model {

    @JsonIgnore
    private Long id;
    private Integer modelCode;
    private String name;
    private Integer brandCode;
}
