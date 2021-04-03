package com.javarush.task.task08.task0815;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> people = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            people.put("Family" + (((i > 6) && (i < 3)) ? 2 : i), "Name" + ((i > 7) ? 3 : i));
        }
        return people;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int j = 0;
        Collection<String> names = map.values();
        for (String i : names) if (i.equals(name)) ++j;
        return j;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        return (map.containsKey(lastName) ? 1 : 0);
    }

    public static void main(String[] args) {
       /* Map<String, String> people = createMap();
        for(Map.Entry<String, String> i : people.entrySet()) System.out.println(i.getKey() + " - " + i.getValue());
        System.out.println();
        System.out.println(getCountTheSameFirstName(people, "Name1"));
        System.out.println(getCountTheSameFirstName(people, "Name3"));
        System.out.println(getCountTheSameLastName(people, "Family5"));
        System.out.println(getCountTheSameLastName(people, "Family11"));*/
        /*removeItemFromMap(people);
        for(Map.Entry<String, Integer> i : people.entrySet()) System.out.println(i.getKey() + " - " + i.getValue());*/
    }
}
