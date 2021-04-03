package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int a = number/100;
        //System.out.println(a);
        int b = (number - a*100)/10;
        //System.out.println(b);
        //System.out.println(a*100 + b*10);
        int c = (number - a*100 - b*10);
        return  a+b+c;//напишите тут ваш код

    }
}