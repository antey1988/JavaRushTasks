package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        if (n <= 1) return;
        boolean simpleNum = true;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                simpleNum = false;
                System.out.print(i + " ");
                recurse(n/i);
                break;
            }
        }
        if (simpleNum) System.out.println(n);
    }

    /*public static void main(String[] args) {
        new Solution().recurse(750);
    }*/
}
