package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0],"wr");
        raf.seek(Integer.parseInt(args[1]));
        byte[] array = new byte[args[2].length()];
        raf.read(array, 0 , array.length);
        String text2, text = new String(array);
        if (text.equals(args[2])) text2 = "true"; else text2 = "false";
        raf.seek(raf.length());
        raf.write(text2.getBytes());
    }
}
