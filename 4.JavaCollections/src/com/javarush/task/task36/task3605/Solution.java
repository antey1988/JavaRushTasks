package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set strinfile = new TreeSet();
        TreeSet<Character> infile = new TreeSet<>();

        TreeSet<Character> alphafit = new TreeSet<>();
        for(int i = 97; i <= 122; i++) alphafit.add((char) i);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]))) {
            int countbyte = bis.available();
            while (countbyte > 0) {
                countbyte--;
                char Symbol = (char)bis.read();
                infile.add(Character.toLowerCase(Symbol));
            }
        }

        infile.retainAll(alphafit);

        int k = 0;
        for (char ch : infile) {
            System.out.print(ch);
            if (++k > 4) break;
        }

    }
}
