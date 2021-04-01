package com.javarush.task.task19.task1926;

/* 
Перевертыши
/home/oleg/Документы/task1926.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader filename = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(filename.readLine()));
        filename.close();
        String string;
        int k = 0;
        while ((string = br.readLine()) != null) {
//            string.
//            System.out.println(string.charAt(string.length()-1));
            if (k != 0) System.out.println();
            for (int i = string.length() - 1; i >= 0; i--) {
                System.out.print(string.charAt(i));
            }
            k++;
        }
        br.close();
    }
}
