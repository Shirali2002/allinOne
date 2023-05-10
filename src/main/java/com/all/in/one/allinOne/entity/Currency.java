package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Currency {

    @JsonIgnore
    private Long id;
    private Integer currencyCode;
    private String name;

}
