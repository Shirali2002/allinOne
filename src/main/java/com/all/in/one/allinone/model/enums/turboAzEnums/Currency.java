package com.all.in.one.allinone.model.enums.turboAzEnums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Currency {

    AZN("AZN", 1),
    USD("USD", 2),
    EUR("EUR", 3);

    private final String value;
    private final int id;

    Currency(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static Currency getCurrency(String value) {
        return Arrays.stream(Currency.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}
