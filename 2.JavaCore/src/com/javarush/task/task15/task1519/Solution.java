package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string;
        Double d;
        Integer i;
        while (!(string = br.readLine()).equals("exit")) {
            try {
                d = Double.parseDouble(string);
                try {
                    i = Integer.parseInt(string);
                    if (i > 0 && i < 128) print((short)(int)i);
                    else print(i);
                } catch (NumberFormatException e) {
                    print(d);
                }
            } catch (NumberFormatException e) {
                print(string);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
