package com;

import java.io.StringReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class ComplexNumber {
    private double Re;
    private double Im;
    private double Mod;
    private double Ang;

    public ComplexNumber(double re, double im) {
        this(re, im, true);
    }

    public ComplexNumber(double mod, double ang, boolean flag) {
        if (flag) {
            Re = mod;
            Im = ang;
            trigToExp();
        } else {
            Mod = mod;
            Ang = ang;
            expToTrig();
        }
    }

    public double getRe() {
        return Re;
    }

    public double getIm() {
        return Im;
    }

    public double getMod() {
        return Mod;
    }

    public double getAng() {
        return Ang;
    }

    public void expToTrig() {
        Re = Mod * Math.cos(Ang);
        Im = Mod * Math.sin(Ang);
    }

    public void trigToExp() {
        Mod = Math.sqrt(Re * Re + Im * Im);
        Ang = Math.atan(Im/Re);
    }

    public static ComplexNumber add(ComplexNumber Z1, ComplexNumber Z2) {
        return new ComplexNumber(Z1.Re + Z2.Re, Z1.Im + Z2.Im);
    }

    public static ComplexNumber multiply(ComplexNumber Z1, ComplexNumber Z2) {
        return new ComplexNumber(Z1.Re*Z2.Re - Z1.Im*Z2.Im, Z1.Re*Z2.Im + Z1.Im*Z2.Re);
    }

    public static ComplexNumber multiplyOnInt(ComplexNumber Z, int n) {
        return new ComplexNumber(Z.Re*n, Z.Im*n);
    }

    public static ComplexNumber[] sqrt(ComplexNumber Z, int n) {
        double angRad = 2*Math.PI / n;
        Stream<ComplexNumber> stream = Stream.iterate(0, i->++i).limit(n)
                .map((i)->new ComplexNumber(Z.Mod, Z.Ang/n + angRad*i, false));
        return stream.toArray(ComplexNumber[]::new);

    }

    public static ComplexNumber pow(ComplexNumber Z, int n) {
        return new ComplexNumber(Z.Mod, Z.Ang*n, false);
    }

    @Override
    public String toString() {
        return String.format("%+.3f%+.3f*i", Re, Im);
    }


}
