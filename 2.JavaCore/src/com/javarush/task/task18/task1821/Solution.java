package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.nio.charset.Charset;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] code = new int[256];
        InputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        while (bis.available() > 0) {
            byte b = (byte)bis.read();
            code[b]++;
        }
        bis.close();
        fis.close();
        for (int i = 0; i < 256; i++) {
            if (code[i] != 0) System.out.println((char)i + " " + code[i]);
        }
    }
}
