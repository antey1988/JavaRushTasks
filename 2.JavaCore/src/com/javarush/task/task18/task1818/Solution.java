package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name1 = br.readLine();
        String name2 = br.readLine();
        String name3 = br.readLine();
        br.close();

//        byte input

//        int currentByte, countBytes;
        FileInputStream fis = new FileInputStream(name2);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(name1, true);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        while (bis.available() > 0) {
            bos.write(bis.read());
        }
        fis.close();

        fis = new FileInputStream(name3);
        bis = new BufferedInputStream(fis);

        while (bis.available() > 0) {
            bos.write(bis.read());
        }
        fis.close();
        bis.close();

        bos.close();
        fos.close();
    }
}
