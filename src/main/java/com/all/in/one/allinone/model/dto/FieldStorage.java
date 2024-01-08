package com.all.in.one.allinone.model.dto;

import lombok.Data;

@Data
public class FieldStorage {


    private final static FieldStorage INSTANCE = new FieldStorage();

    private Integer code;
    private String name;

    private FieldStorage() {
    }

    public static FieldStorage singletonOf(Integer code, String name) {
        INSTANCE.setCode(code);
        INSTANCE.setName(name);

        return INSTANCE;
    }

}
