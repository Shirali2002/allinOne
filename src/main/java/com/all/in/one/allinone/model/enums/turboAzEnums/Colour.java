package com.all.in.one.allinone.model.enums.turboAzEnums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Colour {

    QARA("Qara", 5),
    YAS_ASFALT("Yaş Asfalt", 27),
    BOZ("Boz", 7),
    GUMUSU("Gümüşü", 8),
    AG("Ağ", 2),
    BEJ("Bej", 12),
    TUND_QIRMIZI("Tünd qırmızı", 35),
    QIRMIZI("Qırmızı", 1),
    CEHRAYI("Çəhrayı", 21),
    NARINCI("Narıncı", 15),
    QIZILI("Qızılı", 14),
    SARI("Sarı", 6),
    YASIL("Yaşıl", 4),
    MAVI("Mavi", 9),
    GOY("Göy", 3),
    BENOVSEYI("Bənövşəyi", 11),
    QEHVEYI("Qəhvəyi", 10);

    private final String value;
    private final int id;

    Colour(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static Colour getColour(String value) {
        return Arrays.stream(Colour.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

}
