package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> people = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            people.put("Family" + i, (int) (500+Math.pow(-1, i)*10*i));
        }
        return people;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String,Integer> entry = iter.next();
            if ((int) entry.getValue() < 500) iter.remove();
        }
    }

    public static void main(String[] args) {
        /*Map<String, Integer> people = createMap();
        for(Map.Entry<String, Integer> i : people.entrySet()) System.out.println(i.getKey() + " - " + i.getValue());
        System.out.println();
        removeItemFromMap(people);
        for(Map.Entry<String, Integer> i : people.entrySet()) System.out.println(i.getKey() + " - " + i.getValue());*/

    }
}