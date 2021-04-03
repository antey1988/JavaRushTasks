package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(fileName2);
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            int k = 0;
//            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\\.","!");
                if ( k != 0) bw.newLine();
                bw.write(line);
                k++;
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
