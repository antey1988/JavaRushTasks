package com;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Util {
    public static void main(String[] args) {
        final int Count = 16;
    }

    public static int reverseBit(int input, int size) {
        StringBuilder string = new StringBuilder(Integer.toBinaryString(input));
        while (string.length() < size)
            string.insert(0, "0");
        string.reverse();
        return Integer.parseInt(string.toString(),2);
    }

    public static int[] supplementZeroReports(int[] input, int countReports) {
        if (countReports < input.length) throw new IllegalArgumentException("");
        if (countReports == input.length) return input;
        return Arrays.copyOf(input, countReports);
    }

    public static int[] getOrderReports(int countReports) {
        int countMultiply = (int)(Math.log(countReports)/Math.log(2));
        return IntStream.iterate(0, i->++i).limit(countReports).map(i->reverseBit(i,countMultiply)).toArray();
    }

    public static int[] getIndexsBasisFunction(int numberMultiply, int countReports) {
        int step = countReports / (int)Math.pow(2, numberMultiply);
        int count = (int)Math.pow(2, numberMultiply - 1);
        return IntStream.iterate(0, i->i+step).limit(count).toArray();
    }

}
