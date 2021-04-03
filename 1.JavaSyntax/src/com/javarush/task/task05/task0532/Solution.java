package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;
        int count = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= count; i++) {
            int number = Integer.parseInt(reader.readLine());
            maximum = maximum > number ? maximum : number;
        }
        System.out.println(maximum);
    }
}
