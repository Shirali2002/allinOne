package com.all.in.one.allinOne.domain;

import lombok.Getter;

@Getter
public enum Role {

    USER(1),
    ADMIN(2),
    UNKNOWN(-1);

    private final int id;

    Role(int id) {
        this.id = id;
    }

}
