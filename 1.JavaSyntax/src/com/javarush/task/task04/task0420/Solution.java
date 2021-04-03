package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());
        int number3 = Integer.parseInt(bufferedReader.readLine());
        int number;

        if (number1 < number2) {
            number = number2;
            number2 = number1;
            number1 = number;
        }
        if (number1 < number3) {
            number = number3;
            number3 = number1;
            number1 = number;
        }
        if (number2 < number3) {
            number = number3;
            number3 = number2;
            number2 = number;
        }
        System.out.println(number1 + " " + number2 + " " + number3);
    }
}
