package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSimvolov = 0;
        int countProbelov = 0;
        InputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        while (bis.available() > 0) {
            byte b = (byte)bis.read();
//            char c = (char)b;
//            System.out.println(c + " : " + b);
            countSimvolov++;
            if (b == 32) countProbelov++;
        }
        bis.close();
        fis.close();
        System.out.println(
                Math.round(10000.0 * countProbelov / countSimvolov) / 100.0);
    }
}
