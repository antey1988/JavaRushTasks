package com.javarush.task.task18.task1819;

/* 
Объединение файлов
/home/oleg/Документы/result1.txt
/home/oleg/Документы/result2.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name1 = br.readLine();
        String name2 = br.readLine();
        br.close();

//        byte input

//        int currentByte, countBytes;
        FileInputStream fis = new FileInputStream(name1);
        byte[] firstFile = new byte[fis.available()];
        fis.read(firstFile);
        fis.close();
//        BufferedInputStream bis = new BufferedInputStream(fis);
        fis = new FileInputStream(name2);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(name1);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        while (bis.available() > 0) {
            bos.write(bis.read());
        }
        bos.write(firstFile);

        fis.close();
        bis.close();

        bos.close();
        fos.close();
    }
}
