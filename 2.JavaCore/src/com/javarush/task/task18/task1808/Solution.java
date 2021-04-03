package com.javarush.task.task18.task1808;

/* 
Разделение файла
e:/result.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name1 = br.readLine();
        String name2 = br.readLine();
        String name3 = br.readLine();
        br.close();

        int currentByte, countBytes;
        FileInputStream inputStream = new FileInputStream(name1);
        countBytes =  inputStream.available();
//        System.out.println(countBytes);

        FileOutputStream outputStream = new FileOutputStream(name2);
        while ((inputStream.available() > 0) && (inputStream.available() > (countBytes) / 2)) {
            outputStream.write(inputStream.read());
        }
        outputStream.close();

        outputStream = new FileOutputStream(name3);
        while (inputStream.available() > 0) {
            outputStream.write(inputStream.read());
        }
        outputStream.close();
        inputStream.close();
    }
}
