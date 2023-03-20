package com.all.in.one.allinOne.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum FuelType {

    BENZIN("Benzin", 1),
    DIZEL("Dizel", 2),
    QAZ("Qaz", 3),
    ELEKTRO("Elektro", 4),
    HIBRID("Hibrid", 5),
    PLUG_IN_HIBRID("Plug-in Hibrid", 6),
    UNKNOWN("unknown", -1);

    private final String value;
    private final int id;

    FuelType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static FuelType getFuelType(String value) {
        return Arrays.stream(FuelType.values())
                .filter(f -> f.getValue().equals(value))
                .findFirst()
                .orElse(FuelType.UNKNOWN);
    }

}
