package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        /*System.out.println(isPalindromePermutation("dfslupdfjd"));
        System.out.println(isPalindromePermutation("abba"));
        System.out.println(isPalindromePermutation("bbaaaab"));
        System.out.println(isPalindromePermutation("bbb"));
        System.out.println(isPalindromePermutation("bB"));
        System.out.println(isPalindromePermutation("b"));*/
    }

    public static boolean isPalindromePermutation(String s) {
        Map<Integer, Integer> symbols = new HashMap<>();
        s.toLowerCase().chars().sorted().boxed().forEach(c->symbols.merge(c,1, Integer::sum));
        long count = symbols.entrySet().stream().filter(e->e.getValue() % 2 == 1).count();
        return count <= 1;
    }
}
