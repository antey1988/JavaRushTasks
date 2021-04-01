package com.tracks;

public class FrequencyRange implements Comparable<FrequencyRange>, Range {
    public static final FrequencyRange EMPTY = new FrequencyRange(0,0);
    private int startFreq;
    private int stopFreq;

    public FrequencyRange(int startFreq, int stopFreq) {
        this.startFreq = startFreq;
        this.stopFreq = stopFreq;
    }

    public FrequencyRange(double startFreq, double stopFreq) {
        this((int) startFreq *1000, (int) stopFreq *1000);
    }

    public int getStartFreq() {
        return startFreq;
    }

    public int getStopFreq() {
        return stopFreq;
    }

    public Range crossRange(Range other) {
        if (startFreq <= other.getStartFreq()) {
            if (stopFreq < other.getStartFreq()) return EMPTY;
            return new FrequencyRange(other.getStartFreq(), Math.min(stopFreq, other.getStopFreq()));
        } else {
            return other.crossRange(this);
        }
    }

    public FrequencyRange moveRange(int value) {
        return new FrequencyRange(startFreq + value, stopFreq + value);
    }

    public FrequencyRange dividedRange(int n) {
        startFreq = startFreq / n;
        stopFreq = stopFreq / n;
        return this;
    }

    public FrequencyRange inverseRange() {
        return new FrequencyRange(-stopFreq, -startFreq);
    }

    @Override
    public String toString() {
        return String.format("Frequency range: %d ÷ %d %s", startFreq, stopFreq, Frequency.units);
    }

    @Override
    public int compareTo(FrequencyRange o) {
        return Integer.compare(startFreq, o.startFreq);
    }
}
