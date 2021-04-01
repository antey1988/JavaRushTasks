package com.tracks;

import com.Combination;
import com.enums.SideBand;

public class TractIFLossable extends Tract {
    private int midFreq;

    public TractIFLossable(int midFreq, Range bandGain, Range bandLoss) {
        super(bandGain, bandLoss);
        this.midFreq = midFreq;
    }

    public int getMidFreq() {
        return midFreq;
    }

    @Override
    public String toString() {
        return String.format("Tract IF: %d ÷ %d %s, Fc = %d %s",
                bandGain.getStartFreq(), bandGain.getStopFreq(), Frequency.units, getMidFreq(), Frequency.units);
    }

    public Frequency getFreqGeterodin(int freqRF, SideBand sideBand, int nLO) {
        Combination combination = new Combination(1, 1, sideBand.getMixing());
        int fr = combination.mixed(midFreq, freqRF);
        return new Frequency(fr/nLO);
    }

}
