package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        double a = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
        a = a % 5;
        if (a < 3) {
            System.out.println("зелёный");
        } else if (a < 4) {
            System.out.println("жёлтый");
        } else {
            System.out.println("красный");
        }
    }
}