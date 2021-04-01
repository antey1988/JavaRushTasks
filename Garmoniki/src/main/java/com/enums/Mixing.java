package com.enums;

public enum Mixing {
    SUM(1), DIFF(-1);
    private final int value;

    Mixing(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
