package com.all.in.one.allinone.model.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Colour implements Serializable {

    @JsonIgnore
    private Long id;
    private Integer colourCode;
    private String name;

}
