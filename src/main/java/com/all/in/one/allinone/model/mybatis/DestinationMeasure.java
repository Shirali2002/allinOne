package com.all.in.one.allinone.model.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DestinationMeasure {

    @JsonIgnore
    private Long id;
    private Integer destCode;
    private String name;

}
