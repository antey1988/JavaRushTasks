package com;

import com.enums.Mixing;
import java.util.Set;
import java.util.TreeSet;

public class Mixer {
    private int countRF;
    private int countLO;
    private Set<Combination> activeCombination = new TreeSet<>();
    private Set<Combination> passiveCombination;

    public Mixer(int countRF, int countLO) {
        this.countRF = countRF;
        this.countLO = countLO;
        generateActiveCombinations();
    }

    public Mixer(int countRF, int countLO, Set<Combination> passiveCombination) {
        this.countRF = countRF;
        this.countLO = countLO;
        this.passiveCombination = passiveCombination;
        generateActiveCombinations();
    }

    public int getCountRF() {
        return countRF;
    }

    public void setCountRF(int countRF) {
        this.countRF = countRF;
        generateActiveCombinations();
    }

    public int getCountLO() {
        return countLO;
    }

    public void setCountLO(int countLO) {
        this.countLO = countLO;
        generateActiveCombinations();
    }

    public Set<Combination> getPassiveCombination() {
        return passiveCombination;
    }

    public void setPassiveCombination(Set<Combination> passiveCombination) {
        this.passiveCombination = passiveCombination;
        generateActiveCombinations();
    }

    public Set<Combination> getActiveCombination() {
        return activeCombination;
    }

    private void generateActiveCombinations() {
        activeCombination.clear();
        for (int i = 0; i <= countRF; i++) {
            for (int j = 0; j <= countLO; j++) {
                if ((i == 0 && j == 0)) continue;
                activeCombination.add(new Combination(i, j, Mixing.SUM));
                activeCombination.add(new Combination(i, j, Mixing.DIFF));
            }
        }
        activeCombination.removeAll(passiveCombination);
    }
}
