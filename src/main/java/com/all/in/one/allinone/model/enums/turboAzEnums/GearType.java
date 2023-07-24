package com.all.in.one.allinone.model.enums.turboAzEnums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum GearType {

    ARXA("Arxa", 1),
    ON("Ön", 2),
    TAM("Tam", 3);

    private final String value;
    private final int id;

    GearType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static GearType getGearType(String value) {
        return Arrays.stream(GearType.values())
                .filter(g -> g.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}
