package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset Win = Charset.forName("Windows-1251");
        Charset UTF8 = Charset.forName("UTF-8");
        InputStream inputStream = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream(args[1]);
        byte[] bytes = new byte[1000];
        while (inputStream.read(bytes) != -1) {
            String string = new String(bytes, Win);
            bytes = string.getBytes(UTF8);
            outputStream.write(bytes);
        }
        outputStream.close();
        inputStream.close();
    }
}
