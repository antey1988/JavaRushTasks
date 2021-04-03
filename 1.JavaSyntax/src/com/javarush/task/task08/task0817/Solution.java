package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {

    public static void main(String[] args) {
        Map<String, String> people = createMap();
        for (Map.Entry<String, String> i : people.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
            //System.out.println(1);
        }
//        System.out.println(people);
        System.out.println();
        removeTheFirstNameDuplicates(people);
//        System.out.println(people);
        for (Map.Entry<String, String> i : people.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
//            System.out.println(2);
        }
    }

    public static Map<String, String> createMap() {
        Map<String, String> people = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int j;
            if (i < 2) j = 0;
            else if (i > 7) j = 3;
            else j = i;
            people.put("Family" + i, "Name" + j);
        }
        return people;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Collection<String> values =  map.values();
        List<String> list = new ArrayList<>(values);
        Set<String> set = new HashSet<>();
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(list.get(i+1))) {set.add(list.get(i));
                //System.out.println(1);
            }
        }
        for (String value : set) {
            removeItemFromMapByValue(map, value);
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
//        System.out.println(2);
    }

    /*public static void main(String[] args) {
        Map<String, String> people = createMap();
        for (Map.Entry<String, String> i : people.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
            //System.out.println(1);
        }
        System.out.println(people);
        System.out.println();
        removeTheFirstNameDuplicates(people);
        System.out.println(people);
        for (Map.Entry<String, String> i : people.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
            System.out.println(2);
        }
    }*/
}
