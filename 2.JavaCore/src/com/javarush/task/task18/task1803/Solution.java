package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
/home/oleg/Документы/test2.txt
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name = br.readLine();
        br.close();

        int [] arrayBytes = new int [256];
        int currentByte;
        FileInputStream inputStream = new FileInputStream(name);
        while (inputStream.available() > 0) {
            currentByte = inputStream.read();
            arrayBytes[currentByte]++;
//            System.out.println((char)currentByte + " : " + currentByte);
//            if (currentByte < minByte) minByte = currentByte;
        }
        inputStream.close();

        List<Integer> list = new ArrayList<>();
        int maxInt = 0;
        for (int i = 0; i < arrayBytes.length; i++) {
            if (arrayBytes[i] > maxInt) {
                list.clear();
                list.add(i);
                maxInt = arrayBytes[i];
            } else if (arrayBytes[i] == maxInt) {
                list.add(i);
            }
        }

        System.out.print(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }
}
