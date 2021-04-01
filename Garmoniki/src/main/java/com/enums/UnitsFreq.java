package com.enums;

public enum UnitsFreq {
    Hz, kHz, MHz, GHz;

    public static double[] getCoefficients(UnitsFreq unit1, UnitsFreq unit2) {
        int minUnit = Math.min(unit1.ordinal(), unit2.ordinal());
        double coeff1 = Math.pow(10, 3* (unit1.ordinal() - minUnit));
        double coeff2 = Math.pow(10, 3* (unit2.ordinal() - minUnit));
        return new double[]{coeff1, coeff2};
    }

    public static UnitsFreq getMinUnits(UnitsFreq unit1, UnitsFreq unit2) {
        return UnitsFreq.values()[Math.min(unit1.ordinal(), unit2.ordinal())];
    }
}
