package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        Set<String> set = new HashSet<>();
        String L = "Л";
        for (int i = 0; i < 20; i++) {
            set.add(L + i);
        }
        return set;
    }

    public static void main(String[] args) {
        /*Set<String> set = createSet();
        for(String s : set) System.out.println(s);*/
    }
}
