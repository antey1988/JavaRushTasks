package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int i = 0;
//        InputStream inputStream;
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        while (i < 3) {
            String filename = reader.readLine();
            try {
                InputStream inputStream = new FileInputStream(filename);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                while (bufferedInputStream.available() > 0)   {
                    System.out.print((char) bufferedInputStream.read());
                }
                bufferedInputStream.close();
                inputStream.close();
                break;
            } catch (FileNotFoundException e) {
                System.out.println("указанного файла не существует. Введите название существующего файла");
            }
        }
        reader.close();
    }
}