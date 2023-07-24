package com.all.in.one.allinone.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Role {

    USER(1),
    ADMIN(2);

    private final int id;

    public static Role getRole(int id) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getId() == id)
                .findFirst().orElse(USER);
    }

}
