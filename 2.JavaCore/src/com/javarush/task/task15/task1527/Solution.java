package com.javarush.task.task15.task1527;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.LongUnaryOperator;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int flag = 0;
        double d = 0;
        String s = "";
        String nameParametrs = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        string = string.substring(string.indexOf('?') + 1);
//        parametrs = string.split("\\?");
//        parametrs = parametrs[1].split("&");
        String[] parametrs = string.split("&");
        for (String str : parametrs) {
            String[] parametr = str.split("=");
            nameParametrs += (" " + parametr[0]);
            if (parametr[0].equals("obj")) {
                try {
                    d = Double.parseDouble(parametr[1]);
                    flag = 1;
                } catch (NumberFormatException e) {
                    s = parametr[1];
                    flag = -1;
                }
            }
//            System.out.print(str + "| ");
//            System.out.println(str.indexOf('='));
        }
        System.out.println(nameParametrs.substring(2));
        if (flag > 0) alert(d); else if (flag < 0) alert(s);

    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
