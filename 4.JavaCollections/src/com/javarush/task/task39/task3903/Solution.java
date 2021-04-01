package com.javarush.task.task39.task3903;

import org.jsoup.select.Evaluator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
//        swapBits(10,2,3);
//        swapBits(-3,1,0);
//        swapBits(Long.MIN_VALUE, 63 , 62);
    }

    public static long swapBits(long number, int i, int j) {
        String word = String.format("%64s", Long.toBinaryString(number)).replace(' ', '0');
        char iChar = word.charAt(63 - i);
        char jChar = word.charAt(63 - j);
        char [] arrayChar = word.toCharArray();
        arrayChar[63-j] = iChar;
        arrayChar[63-i] = jChar;
        String newWord = new String(arrayChar);
        /*System.out.println(word);
        System.out.println(Long.parseUnsignedLong(word, 2));
        System.out.println(newWord);
        System.out.println(Long.parseUnsignedLong(newWord, 2));*/
        return Long.parseUnsignedLong(newWord, 2);
    }
}
