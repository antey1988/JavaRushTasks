package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
/home/oleg/Документы/task1923.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String string;

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        int k = 0;
//        String s;
        while ((string = br.readLine()) != null) {
            String[] words = string.split("\\s");
//            String s;
            for(String s : words) {
                if (s.length() != s.replaceAll("\\d", "").length()) {
                    if (k != 0) bw.write(" ");
                    bw.write(s);
                    k++;
                }
            }
        }
        bw.close();
        br.close();
    }
}
