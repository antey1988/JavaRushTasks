package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());
        int number3 = Integer.parseInt(bufferedReader.readLine());
        int number4 = Integer.parseInt(bufferedReader.readLine());
        System.out.println(max(max(number1, number2), max(number3, number4)));
    }

    static int max(int n1, int n2) {
        if (n1 > n2) return n1;
        else return n2;
    }
}
