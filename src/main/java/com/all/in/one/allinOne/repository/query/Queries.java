package com.all.in.one.allinOne.repository.query;

public enum Queries {

    FIND_USER_BY_ID("findUserById"),
    ADD_USER("addUser"),
    FIND_USER_BY_USERNAME("findUserByUsername");

    private final String key;

    Queries(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

}