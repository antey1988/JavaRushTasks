package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");
        for (int i = 0; i < 3; i++) {
            strings.add(i*2+1, "именно");
        }
        //strings.add("именно");

        for (int i = 0; i < 6; i++) {
            System.out.println(strings.get(i));
        }
    }
}
