package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> data = new TreeMap<>();
        String string;
        while ((string = br.readLine()) != null) {
            String[] words = string.split("\\s");
            String _name = words[0];
            Double _value = Double.parseDouble(words[1]);
            if (data.containsKey(_name)) data.put(_name, data.get(_name) + _value);
            else data.put(_name,  _value);
        }
        br.close();

        for(Map.Entry<String, Double> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
