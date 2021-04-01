package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {/*
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(81));
        System.out.println(isPowerOfThree(80));*/

    }

    public static boolean isPowerOfThree(int n) {
        double pow = Math.log(n)/Math.log(3);
        return pow == (int) pow;
    }
}
