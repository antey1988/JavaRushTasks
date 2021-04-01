package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Биты были биты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");
//        isWeightEven(12);
    }

    public static boolean isWeightEven(long number) {
        int countDigit = (int)(Math.log(number)/Math.log(2))+1;
//        List<Long> list =
                long n = Stream.iterate(new long[]{number, 0L}, l -> new long[]{l[0]/2, l[1]+l[0]%2})
                .limit(countDigit+1)
                .map(l->l[1])
                .skip(countDigit)
                .findFirst().get();
//                .collect(Collectors.toList());
        return (n%2 == 0);
    }
}
