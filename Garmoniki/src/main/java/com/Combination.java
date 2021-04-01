package com;

import com.enums.Mixing;
import com.tracks.Frequency;

public class Combination implements Comparable<Combination> {
    private Mixing mixing;
    private int nF1;
    private int nF2;

    public Combination(int nF1, int nF2, Mixing mixing) {
        this.nF1 = nF1;
        this.nF2 = nF2;
        this.mixing = mixing;
    }

    public Mixing getMixing() {
        return mixing;
    }

    public int getnF1() {
        return nF1;
    }

    public int getnF2() {
        return nF2;
    }

    public Signal mixed(Frequency freqF1, Frequency freqF2) {
        int valueF3 = mixed(freqF1.getValue(), freqF2.getValue());
        int up = 1;
        if (valueF3 < 0) {
            valueF3 = -valueF3;
            up = -1;
        }
        return new Signal(String.format("%6$s_%1$dF1(%2$d %5$s)_%3$dF2(%4$d %5$s)", nF1, freqF1.getValue(), nF2, freqF2.getValue(), Frequency.units, mixing),
                valueF3, up);
    }

    public int mixed(int freqF1, int freqF2) {
        return nF1 * freqF1 + mixing.getValue() * nF2 * freqF2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination combination = (Combination) o;

        if (nF1 != combination.nF1) return false;
        if (nF2 != combination.nF2) return false;
        if (nF1 == 0 || nF2 == 0) return true;
        return mixing == combination.mixing;
    }

    @Override
    public int hashCode() {
        int result = nF1 + nF2;
        result = 31 * result + nF1;
        result = 31 * result + nF2;
        if (nF1 != 0 && nF2 != 0) {
            result = result + (mixing == null ? 0 : mixing == Mixing.SUM ? 2 : 1);
        }
        return result;
    }

    @Override
    public int compareTo(Combination o) {
        return hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return "Mixer: " +
                mixing + "_" +
                nF1 + "F1_" +
                nF2 + "F2";
    }
}
