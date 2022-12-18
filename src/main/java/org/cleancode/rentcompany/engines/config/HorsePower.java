package org.cleancode.rentcompany.engines.config;

public enum HorsePower {
    SMALL(100),
    MEDIUM(200),
    LARGE(300);

    private final int value;

    HorsePower(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
