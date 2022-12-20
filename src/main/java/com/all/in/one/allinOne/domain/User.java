package com.all.in.one.allinOne.domain;

import lombok.Data;

import java.util.Arrays;

@Data
public class User {

    private int id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private Role role;

    public User() {
    }

    public User(int id, String username, String name, String surname, String password, int roleId) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = Arrays.stream(Role.values())
                .filter(role -> role.getId() == roleId)
                .findFirst().orElse(Role.UNKNOWN);
    }

    public User(int id, String username, String name, String surname, String password, Role role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public int getRoleId() {
        return role.getId();
    }

}