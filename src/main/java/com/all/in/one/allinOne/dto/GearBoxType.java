package com.all.in.one.allinOne.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum GearBoxType {

    MEXANIKI("Mexaniki", 1),
    AVTOMAT("Avtomat", 2),
    ROBOTLASDIRILMIS("Robotlaşdırılmış", 3),
    VARIATOR("Variator", 4);

    private final String value;
    private final int id;

    GearBoxType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static GearBoxType getGearBoxType(String value) {
        return Arrays.stream(GearBoxType.values())
                .filter(g -> g.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}
