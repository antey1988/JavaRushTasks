package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

        String string;
        int k = 0;
        while((string = br.readLine()) != null) {
            for(String s : string.split("\\s")) {
                if (s.length() > 6) {
                    if (k != 0) bw.write(",");
                    bw.write(s);
                    k++;
                }
            }
        }
        br.close();bw.close();
    }
}
