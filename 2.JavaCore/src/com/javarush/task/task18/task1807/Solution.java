package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*try {
            char[] testChars = new char[] {'a','b','c','d','e','f','g',',',' ','1','2','3','4','5','6','7'};
            String str = new String(testChars);
            System.out.println(str);
            byte[] bytes = str.getBytes("ascii");
//            char[] chars = str.

            // Получам код символа в ASCII кодировке
            // ВНИМАНИЕ! Это можно делать только если кодировка однобайтная (в Юникоде символ может кодироваться от 1 до 3 байтами)
            for ( int i = 0; i < testChars.length; i++ )
                System.out.println(testChars[i] + ": " + bytes[i] );

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }*/
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name = br.readLine();
        br.close();

        int currentByte, count = 0;
        FileInputStream inputStream = new FileInputStream(name);
        while (inputStream.available() > 0) {
            currentByte = inputStream.read();
//            System.out.println((char)currentByte + " : " + currentByte);
            if (currentByte == 44) count++;
        }
        inputStream.close();

        System.out.println(count);

    }
}
