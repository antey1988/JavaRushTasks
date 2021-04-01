package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = null;
            try {
                string = reader.readLine();
                try {
                    int a = Integer.parseInt(string);
                    list.add(a);
                } catch (NumberFormatException e) {
                    for (Integer i : list) {
                        System.out.println(i);
                    }
                    break;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
