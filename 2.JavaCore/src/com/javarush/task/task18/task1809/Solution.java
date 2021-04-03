package com.javarush.task.task18.task1809;

/* 
Реверс файла
e:/result.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name1 = br.readLine();
        String name2 = br.readLine();
//        String name3 = br.readLine();
        br.close();

        int currentByte, countBytes;
        FileInputStream inputStream = new FileInputStream(name1);
//        countBytes =  inputStream.available();
//        System.out.println(countBytes);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(name2);
        for (int i = bytes.length - 1; i >= 0 ; i--) {
            outputStream.write(bytes[i]);
        }
        outputStream.close();

    }
}
