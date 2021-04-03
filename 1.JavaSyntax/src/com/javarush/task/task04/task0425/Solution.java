package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());
        System.out.println(Solution.quadra(number1, number2));
    }
    static int quadra(int n1, int n2) {
        if ((n1 > 0 ) && (n2 > 0)) return 1;
        if ((n1 > 0 ) && (n2 < 0)) return 4;
        if ((n1 < 0 ) && (n2 > 0)) return 2;
        if ((n1 < 0 ) && (n2 < 0)) return 3;
        return 0;
    }
}
