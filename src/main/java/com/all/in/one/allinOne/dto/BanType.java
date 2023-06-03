package com.all.in.one.allinOne.dto;

import java.util.Arrays;

public enum BanType {

    AVTOBUS("Avtobus",9),
    DARTQI("Dartqı",16),
    FURQON("Furqon",14),
    HETCHBEK("Hetçbek",2),
    KABRIOLET("Kabriolet",11),
    KARVAN("Karvan",26),
    KUPE("Kupe",3),
    KVADROSIKL("Kvadrosikl",25),
    LIFTBEK("Liftbek",28),
    MIKROAVTOBUS("Mikroavtobus",7),
    MINIVAN("Minivan",5),
    MOPED("Moped",27),
    MOTOSIKLET("Motosiklet",20),
    OFFROADER_SUV("Offroader",21),
    PIKAP("Pikap",6),
    QOLFKAR("Qolfkar",22),
    RODSTER("Rodster",8),
    SEDAN("Sedan",1),
    UNIVERSAL("Universal",4),
    VAN("Van",19),
    YUK_MASINI("Yük maşını",13);

    private final String value;
    private final int id;

    BanType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static BanType getBanType(String value) {
        return Arrays.stream(BanType.values())
                .filter(b -> b.value.equals(value))
                .findFirst()
                .orElse(null);
    }

}
