package com.javarush.task.task10.task1019;

//import sun.invoke.empty.Empty;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String string = reader.readLine();
            //if (string.isEmpty()) break;
            try {
                int id = Integer.parseInt(string);
                String name = reader.readLine();
                map.put(name, id);

            } catch (NumberFormatException e) {
//                System.out.println("Введенная строка не является числом. Повторите ввод");
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                    System.out.println(entry.getKey() + " " + entry.getValue());
                    System.out.println(entry.getValue() + " " + entry.getKey());
                }
                break;
            }
        }


    }
}
