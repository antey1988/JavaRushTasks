package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int MaxLength = 0, MinLength = Integer.MAX_VALUE, MaxIndex = 0, MinIndex = 0;
        int strok = 10;
        for (int i = 0; i < strok; i++) {
            String string = reader.readLine();
            strings.add(string);
            int dlinaStroki = string.length();
            if (dlinaStroki > MaxLength) {
                MaxLength = dlinaStroki;
                MaxIndex = i;
            }
            if (dlinaStroki < MinLength) {
                MinLength = dlinaStroki;
                MinIndex = i;
            }

        }
        int j = (MaxIndex < MinIndex) ? MaxIndex : MinIndex;
        System.out.println(strings.get(j));
    }
}
