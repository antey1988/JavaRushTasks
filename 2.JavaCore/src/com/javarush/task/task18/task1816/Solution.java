package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        Pattern pattern = Pattern.compile("[a-zA-Z]");
//        System.out.println(pattern.pattern());
//        System.out.println(Pattern.matches("[a-zA-Z]{2,}",Character.toString('a') + 'B'));
        int count = 0;
        InputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        while (bis.available() > 0) {
            String string = Character.toString((char)bis.read());
            if (Pattern.matches("[a-zA-Z]", string)) count++;
        }
        bis.close();
        fis.close();
        System.out.println(count);
    }
}
