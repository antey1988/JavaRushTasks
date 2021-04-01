package com;

import com.enums.Mixing;
import com.enums.SideBand;
import com.tracks.Frequency;
import com.tracks.FrequencyRange;
import com.tracks.Range;
import com.tracks.TractIFRange;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Converter {
    public final static int N = 2;
    private Range inputRange;
    private final TractIFRange tractIFRange;
    private final Mixer mixer;
    private Set<Range> preselectors = new TreeSet<>();
    private final ConcurrentMap<Frequency, Map<Combination, List<Range>>> allSignal = new ConcurrentSkipListMap<>();

    public Converter(Range inputRange, TractIFRange tractIFRange, Mixer mixer) {
        this.inputRange = inputRange;
        this.tractIFRange = tractIFRange;
        this.mixer = mixer;
    }

    public Converter(Set<Range> preselectors, TractIFRange tractIFRange, Mixer mixer) {
        this.tractIFRange = tractIFRange;
        this.preselectors = preselectors;
        this.mixer = mixer;
    }

    public void generateSignalForAllFreq(int step) {
        if (preselectors.isEmpty()) {
            preselectors.add(inputRange);
        }
        for (Range range : preselectors) {
            for (Frequency freq = new Frequency(range.getStartFreq()); freq.isInRange(range); freq = freq.plus(step)) {
                generateSignalForOneFreq(range, freq);
            }
        }
    }

    private void generateSignalForOneFreq(Range range, Frequency RF) {
        Frequency LO = tractIFRange.getFreqGeterodin(RF.getValue(), SideBand.DSB, N);
        for (Combination combination : mixer.getActiveCombination()) {
            FrequencyRange mixedRange = mixedRange(range, LO, combination);
            addIfInRange(mixedRange, LO, RF, combination, true);
            if (combination.getMixing() == Mixing.DIFF)
                addIfInRange(mixedRange, LO, RF, combination, false);
        }
    }

    private FrequencyRange mixedRange(Range inputRange, Frequency LO, Combination combination) {
        int start = combination.mixed(inputRange.getStartFreq(), LO.getValue());
        int stop = combination.mixed(inputRange.getStopFreq(), LO.getValue());
        return new FrequencyRange(start, stop);
    }

    public void addIfInRange(Range range, Frequency LO, Frequency RF, Combination combination, boolean sum) {
        Range crossedRange = sum ? tractIFRange : tractIFRange.inverseRange();
        crossedRange = crossedRange.crossRange(range);
        if (crossedRange != FrequencyRange.EMPTY) {
            crossedRange = realRange(crossedRange, LO, combination);
            addToFullCombination(RF, combination, crossedRange);
        }
    }

    private Range realRange(Range range, Frequency LO, Combination combination) {
        range = range.moveRange(-combination.getMixing().getValue() * combination.getnF2() * LO.getValue());
        range = range.dividedRange(combination.getnF1());
        return range;
    }

    private void addToFullCombination(Frequency frequency, Combination combination, Range frequencyRange) {
        Map<Combination, List<Range>> freqMap = allSignal.computeIfAbsent(frequency, (key)-> new TreeMap<>());
        List<Range> mixerList = freqMap.computeIfAbsent(combination, (key)-> new ArrayList<>());
        mixerList.add(frequencyRange);
    }


    @Override
    public String toString() {
        return "Converter {" + inputRange + "; " + tractIFRange + '}';
    }

    public static void main(String[] args) {

    }
}
