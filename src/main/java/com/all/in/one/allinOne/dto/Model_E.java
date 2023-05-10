package com.all.in.one.allinOne.dto;

import java.util.Arrays;

public enum Model_E {

    AUDI_A7("A7", 9, 1081),
    AUDI_RS6("RS6", 9, 1212),
    AUDI_Q3("Q3", 9, 1385),
    AUDI_A1("A1", 9, 1812),
    AUDI_TTS("TTS", 9, 2376),
    AUDI_RS7("RS7", 9, 2429),
    AUDI_S7("S7", 9, 2452),
    AUDI_RS_Q3("RS Q3", 9, 2944),
    UNKNOWN("unknown", -1, -1);

    private final String nick;
    private final int brandId;
    private final int modelId;

    Model_E(String nick, int brandId, int modelId) {
        this.nick = nick;
        this.brandId = brandId;
        this.modelId = modelId;
    }

    public String getNick() {
        return nick;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getModelId() {
        return modelId;
    }

}
