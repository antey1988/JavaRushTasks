package com.javarush.task.task19.task1920;

/* 
Самый богатый
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
        double _max = 0.0;

        while ((string = br.readLine()) != null) {

            String[] words = string.split("\\s");
            String _name = words[0];
            Double _value = Double.parseDouble(words[1]);
            double _sum = 0.0;
            if (data.containsKey(_name)) _sum =  data.get(_name) + _value; else _sum = _value;
            if (_sum > _max) _max = _sum;
            data.put(_name, _sum);
        }
        br.close();

        for(Map.Entry<String, Double> entry : data.entrySet()) {
            if (entry.getValue().equals(_max))  System.out.println(entry.getKey());
        }
    }
}
