package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые редкие байты
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

        String string = "";
        int minInt = Integer.MAX_VALUE;
        for (int i = 0; i < arrayBytes.length; i++) {
            if (arrayBytes[i] != 0) {
                if (arrayBytes[i] < minInt) {
//                    string = "";
                    string = ("" + i);
                    minInt = arrayBytes[i];
                } else if (arrayBytes[i] == minInt) {
                    string =  string + (" " + i);
                }
            }
        }

        System.out.print(string);

    }
}
