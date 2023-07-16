package com.ijv.internjava.model.entity;

public enum RoleName {
    ROLE_CUSTOMER,
    ROLE_EMPLOYEE,
    ROLE_ADMIN;
    public static RoleName fromString(String input) {
        for (RoleName value : RoleName.values()) {
            if (value.name().equalsIgnoreCase(input)) {
                return value;
            }
        }
        return null;
    }
}
