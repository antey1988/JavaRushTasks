package com.javarush.task.task08.task0801;

/* 
арбуз
банан
вишня
груша
дыня
ежевика
женьшень
земляника
ирис
картофель
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> hashset = new HashSet<>();
        hashset.add("арбуз");
        hashset.add("банан");
        hashset.add("вишня");
        hashset.add("груша");
        hashset.add("дыня");
        hashset.add("ежевика");
        hashset.add("женьшень");
        hashset.add("земляника");
        hashset.add("ирис");
        hashset.add("картофель");

        for (String string : hashset) {
            System.out.println(string);
        }
    }
}
