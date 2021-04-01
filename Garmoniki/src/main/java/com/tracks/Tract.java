package com.tracks;
/*
bandGain - полоса пропускания
bandLoss - полоса фильтрации, включает в себя полосу пропускания
 */
public class Tract implements Lossable {
    protected Range bandGain;
    protected Range bandLoss;
    private int gainInBand = 0;
    private int lossesOutBand = 60;

    public Tract(Range bandGain, Range bandLoss) {
        this.bandGain = bandGain;
        this.bandLoss = bandLoss;
    }

    public Tract(Range bandGain, Range bandLoss, int gainInBand, int lossesOutBand) {
        this(bandGain, bandLoss);
        this.gainInBand = gainInBand;
        this.lossesOutBand = lossesOutBand;
    }

    public double getLosses(Frequency frequency) {
        if (frequency.isInRange(bandGain)) return gainInBand;
        if (!frequency.isInRange(bandLoss)) return gainInBand - lossesOutBand;

        if (frequency.isBetweenFreqs(bandLoss.getStartFreq(), bandGain.getStartFreq())) {
            double k = -1.0*lossesOutBand/(bandLoss.getStartFreq() - bandGain.getStartFreq());
            return gainInBand + k * (frequency.getValue() - bandGain.getStartFreq());
        }

        if (frequency.isBetweenFreqs(bandGain.getStopFreq(), bandLoss.getStopFreq())) {
            double k = -1.0*lossesOutBand/(bandLoss.getStopFreq() - bandGain.getStopFreq());
            return gainInBand + k * (frequency.getValue() - bandGain.getStopFreq());
        }

        return -lossesOutBand;
    }

    public static void main(String[] args) {
        Tract tract = new Tract(new FrequencyRange(1000, 1500), new FrequencyRange(800, 1900));
        System.out.println(tract.getLosses(new Frequency(1200)));
        System.out.println(tract.getLosses(new Frequency(700)));
        System.out.println(tract.getLosses(new Frequency(2000)));
        System.out.println(tract.getLosses(new Frequency(900)));
        System.out.println(tract.getLosses(new Frequency(1600)));
    }
}
