package com.tracks;

import com.Combination;
import com.enums.SideBand;

public class TractIFRange extends FrequencyRange {
    private int midFreq;
    private Lossable tractLoss;

    public TractIFRange(int midFreq, int startFreq, int stopFreq) {
        super(startFreq, stopFreq);
        this.midFreq = midFreq;
    }

    public int getMidFreq() {
        return midFreq;
    }

    @Override
    public String toString() {
        return String.format("Tract IF: %d ÷ %d %s, Fc = %d %s",
                getStartFreq(), getStopFreq(), Frequency.units, getMidFreq(), Frequency.units);
    }

    public Frequency getFreqGeterodin(int freqRF, SideBand sideBand, int nLO) {
        Combination combination = new Combination(1, 1, sideBand.getMixing());
        int fr = combination.mixed(midFreq, freqRF);
        return new Frequency(fr/nLO);
    }

}
