package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
//        checkSeason(2);
    }

    public static void checkSeason(int month) {
       /* if (month < 12) {
            month = month +1;
        } else {
            month = 1;
        }*/


        if (month < 3) {
            System.out.println("зима");
        } else if (month < 6) {
            System.out.println("весна");
        } else if (month < 9) {
            System.out.println("лето");
        } else if (month < 12) {
            System.out.println("осень");
        } else {
            System.out.println("зима");
        }

    }
}