package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
/home/oleg/Документы/task1922.txt
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
       /* words.add("А");
        words.add("Б");
        words.add("В");*/
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(words.contains("А"));
        final int COUNTWORDS = 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(string));
        while ((string = br.readLine()) != null) {
            String[] word = string.split("\\s");
            int count = 0;
            for (String s : word) {
                if (words.contains(s))
                    count++;
            }
            if (count == 2) System.out.println(string);
        }
        br.close();
    }
}
