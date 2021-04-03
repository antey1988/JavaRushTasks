package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        //double Avr = 1;
        int num;
        int N = 0;
        int sum = 0;
        while (true) {
            num = Integer.parseInt(bufferedReader.readLine());
            if (num == -1) {
                //N = 1;
                break;}
            N++;
            sum += num;
        }
        System.out.println((double) sum / N);
    }
}

