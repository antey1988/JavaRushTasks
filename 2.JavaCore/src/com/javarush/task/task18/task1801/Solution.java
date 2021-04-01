package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
/home/oleg/Документы/test.txt
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name = br.readLine();
        br.close();

        int currentByte, maxByte = 0;
        FileInputStream inputStream = new FileInputStream(name);
        while (inputStream.available() > 0) {
            currentByte = inputStream.read();
//            System.out.println((char)currentByte + " : " + currentByte);
            if (currentByte > maxByte) maxByte = currentByte;
        }
        inputStream.close();

        System.out.println(maxByte);
    }
}
