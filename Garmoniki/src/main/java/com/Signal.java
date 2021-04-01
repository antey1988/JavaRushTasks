package com;

import com.tracks.Frequency;

public class Signal {
    private String name;
    private int frequency;
    private int up = 1;

    public Signal(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public Signal(String name, int frequency, int up) {
        this(name, frequency);
        this.up = up;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getUp() {
        return up;
    }

    @Override
    public String toString() {
        return "Signal: " + name +
                " = " + String.format("%d", frequency) + " " + Frequency.units;
    }
}
