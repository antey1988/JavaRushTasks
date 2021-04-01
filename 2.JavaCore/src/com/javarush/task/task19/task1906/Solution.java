package com.javarush.task.task19.task1906;

/* 
Четные символы
/home/oleg/Документы/task1906_input.txt
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName1, fileName2;
        try {
            fileName1 = br.readLine();
            fileName2 = br.readLine();
            br.close();
        } catch (IOException e) {
            e. printStackTrace();
            fileName1 = "";
            fileName2 = "";
        }

        try {
            FileReader fr = new FileReader(fileName1);
//            br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(fileName2);
//            String line;
            while (fr.ready()) {
//                byte[] chars = line.getBytes();
                /*for (int i = 1; i < chars.length; ) {
                    fw.write(chars[i]);
                    i += 2;
                }*/
                fr.read();
                fw.write(fr.read());
            }
            fw.close();
            fr.close();
//            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
