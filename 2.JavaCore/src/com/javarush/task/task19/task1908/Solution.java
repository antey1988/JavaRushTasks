package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
              String [] words = line.split("\\s");
              for( String s : words) {
                  if (s.length() == s.replaceAll("\\D","").length()) list.add(s);
              }
            }
            br.close();

            line = "";
            for (int i = 0; i < list.size() ; i++) {
                line += list.get(i);
                if (i != list.size() - 1) line += " ";
            }

            bw.write(line);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
