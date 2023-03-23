package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Brand {

    @JsonIgnore
    private Long id;
    private Integer brandCode;
    private String name;

}
