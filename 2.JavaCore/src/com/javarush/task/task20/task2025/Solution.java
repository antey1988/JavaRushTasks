package com.javarush.task.task20.task2025;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        long[] result = null;
        System.out.println(LocalTime.now());
        List<Long> res = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            int countRazr = (int)Math.log10(i) + 1;
            long sum = 0;
            long num = i;
            for (int j = 0; j < countRazr; j++) {
                byte raz = (byte)(num % 10);
                sum += Math.pow(raz, countRazr);
                num = num / 10;
            }
            if (sum == i) res.add(i);
        }
        long[] result = new long[res.size()];
        long i = 0;
        for (Long l : res ) {
            result[(int) i] = l;
            i++;
        }
        System.out.println(LocalTime.now());
        return result;
    }

    public static void main(String[] args) {
        for (long l : getNumbers(10000000)) System.out.println(l);
    }
}
