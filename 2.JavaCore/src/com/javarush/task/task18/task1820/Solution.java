package com.javarush.task.task18.task1820;

/* 
Округление чисел
/home/oleg/Документы/task1820_input.txt
/home/oleg/Документы/task1820_output.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name1 = br.readLine();
        String name2 = br.readLine();
        br.close();

        FileReader fr = new FileReader(name1);
        br = new BufferedReader(fr);
        String string = br.readLine();
        br.close();
        FileWriter fw = new FileWriter(name2);
        BufferedWriter bw = new BufferedWriter(fw);

        String[] words = string.split("\\s");
        string = "";
        for (String s : words) {
            try {
                double d = Double.parseDouble(s);
//                System.out.println(s + " : " + Math.round(d));
                string += " " + Math.round(d);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        bw.write(string.substring(1));

        bw.close();
        fw.close();
    }
}
