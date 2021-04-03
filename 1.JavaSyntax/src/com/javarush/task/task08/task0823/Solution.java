package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        //System.out.println(string);
        char[] str = string.toCharArray();
        str[0] = Character.toUpperCase(str[0]);
        System.out.print(str[0]);
        for (int i = 1; i < str.length; i++) {
            if (str[i-1] == ' ') str[i] = Character.toUpperCase(str[i]);
            System.out.print(str[i]);
        }
//        string =
//
//        for (int i = 1; i < string.length(); i++) {
//
//            if (string.charAt(i-1) == ' ') Character.toUpperCase(string.charAt(i));
//        }
//        System.out.println(string);
    }
}
