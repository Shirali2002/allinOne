package com.all.in.one.allinone.model.enums.turboAzEnums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DestinationMeasure {

    KM("km", 1),
    MI("mi", 2);

    private final String value;
    private final int id;

    DestinationMeasure(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static DestinationMeasure getDestinationMeasure(String value) {
        return Arrays.stream(DestinationMeasure.values())
                .filter(d -> d.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}