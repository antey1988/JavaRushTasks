package com.javarush.task.task39.task3904;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0;
        if (n <= 1) return 1;
        List<List<Integer>> num = numberOfPossible(n);
        List<Long> comb = num.stream().map(Solution::numberOfPlacements).collect(Collectors.toList());
        long number = comb.stream().reduce(0L, Long::sum);
//        long cg = numberOfPlacements(new ArrayList<>(Arrays.asList(1,0,4,3)));

        return number;
    }

    private static List<List<Integer>> numberOfPossible(int n) {
        AtomicInteger i = new AtomicInteger(3);
        List<Integer> listDivider = Stream.generate(()->n).limit(3).map(l->l/i.getAndDecrement()).collect(Collectors.toList());
        List<List<Integer>> listSteps = new ArrayList<>();
        int sumMn3;
        int sumMn2;
        int sumMn1;
        int sum;
        int j = listDivider.get(0);
        int k = 0;
        int m = 0;
        while (j >= 0) {
            sumMn3 = 3*j;
            sum = sumMn3;
            if (sum == n) {
                listSteps.add(new ArrayList<>(Arrays.asList(j, k, m)));                ;
            } else {
                k = listDivider.get(1);
                while (k >= 0) {
                    sumMn2 = 2 * k;
                    sum = sumMn3 + sumMn2;
                    if (sum >= n) {
                        if (sum == n) {
                            listSteps.add(new ArrayList<>(Arrays.asList(j, k, m)));
                        }
                    } else {
                        m = listDivider.get(2);
                        while (m > 0) {
                            sumMn1 = m;
                            sum = sumMn3 + sumMn2 + sumMn1;
                            if (sum <= n) {
                                if (sum == n) {
                                    listSteps.add(new ArrayList<>(Arrays.asList(j, k, m)));
                                }
                                break;
                            }
                            m--;
                        }
                    }
                    m = 0;
                    k--;
                }
            }
            k = 0;
            j--;
        }
        return listSteps;
    }

    private static long numberOfPlacements(List<Integer> list) {
        int count = list.stream().filter(integer -> integer > 0).reduce(0, Integer::sum);

        AtomicInteger i = new AtomicInteger(1);
        List<BigDecimal> l1 = Stream.iterate(new BigDecimal(1), l->l.multiply(new BigDecimal(i.incrementAndGet()))).limit(count).collect(Collectors.toList());
        BigDecimal countPosition = l1.get(l1.size()-1);

        List<BigDecimal> l2 =  list.stream()
                .filter(integer -> integer > 0)
                .map(integer -> {
                    AtomicInteger j = new AtomicInteger(1);
                    List<BigDecimal> l3 = Stream.iterate(new BigDecimal(1), l->l.multiply(new BigDecimal(j.incrementAndGet()))).limit(integer)
                            .collect(Collectors.toList());
                    return l3.get(l3.size()-1);
                }).collect(Collectors.toList());
        BigDecimal countRepetitions = l2.stream().reduce(new BigDecimal(1), BigDecimal::multiply);

        return countPosition.divide(countRepetitions).longValue();
    }

}

