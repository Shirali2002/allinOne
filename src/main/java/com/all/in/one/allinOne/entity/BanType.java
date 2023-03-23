package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BanType {

    @JsonIgnore
    private Long id;
    private Integer banTypeCode;
    private String name;

}
