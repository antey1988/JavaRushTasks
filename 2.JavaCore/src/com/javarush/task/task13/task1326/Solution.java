package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        BufferedReader bufferedReaderFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        int i = 0;
        while (i < 3) {
            i++;
            try {
                fileName = bufferedReaderFileName.readLine();
                int number;
                String line;
//                FileReader fr = new FileReader(fileName);
                InputStream fis = new FileInputStream(fileName);
                bufferedReaderFileName.close();
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedReader br = new BufferedReader(new InputStreamReader(bis));
//                BufferedReader br = new BufferedReader(fr);




                while ((line = br.readLine()) != null) {
                    try {
                        number = Integer.parseInt(line);
                        if (number % 2 == 0) list.add(number);
                    } catch (NumberFormatException e) {continue;}
                }
                br.close();
                bis.close();
                fis.close();
//                fr.close();
///home/oleg/Документы/test.txt
                break;
            } catch (FileNotFoundException e) {
                System.out.println("файла с указанным именем не существует. введние правильное имя файла");
                continue;
            }
        }

        Collections.sort(list);
        for (Integer j : list) System.out.println(j);
    }
}
