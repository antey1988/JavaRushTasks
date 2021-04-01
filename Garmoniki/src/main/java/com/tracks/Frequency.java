package com.tracks;

import com.enums.UnitsFreq;

public class Frequency implements Comparable<Frequency> {
    public static UnitsFreq units = UnitsFreq.MHz;
    private int value;

    public Frequency(int value) {
        this.value = value;
    }

    public Frequency(double value) {
        this((int)(value * 1000));
    }

    public int getValue() {
        return value;
    }

    public Frequency plus(int value) {
        return new Frequency(this.value + value);
    }

    public boolean isInRange(Range range) {
        return value >= range.getStartFreq() && value <= range.getStopFreq();
    }

    public boolean isBetweenFreqs(int start, int stop) {
        return value >= start && value <= stop;
    }

    @Override
    public String toString() {
        return String.format("%d", value) + " " + units;
    }

    @Override
    public int compareTo(Frequency o) {
        return Integer.compare(value, o.value);
    }
}
