package com.enums;

public enum SideBand {
    USB(1), DSB(-1);

    private final int inverse;

    SideBand(int inverse) {
        this.inverse = inverse;
    }

    public int getInverse() {
        return inverse;
    }

    public Mixing getMixing() {
        return this == DSB ? Mixing.SUM : Mixing.DIFF;
    }
}
