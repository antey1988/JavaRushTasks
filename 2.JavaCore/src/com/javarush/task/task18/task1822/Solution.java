package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
/home/oleg/Документы/task1822_input.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        Integer id = -1;
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

//        System.out.println(id);

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name1 = br.readLine();
        br.close();
        String line;
        br = new BufferedReader(new FileReader(name1));
        while ((line = br.readLine()) != null) {
           /* line = line.split("\\s", 2)[0];
            System.out.println(line);*/
//           boolean b = line.matches(id + ".*");
//            System.out.println(line.matches(id + ".*"));
//            if (line.startsWith(id + " ")) {
            if (line.matches(id + " .*")) {
                System.out.println(line);
//                System.out.println(line.split("\\s", 2)[1]);
                break;
            }
        }
        br.close();
    }
}
