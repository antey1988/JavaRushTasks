package com.javarush.task.task10.task1004;

/* 
Задача №4 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        short number = 9;
//        System.out.println((char) number);
        char zero = '0';
//        System.out.println((byte) zero);
        int nine =  (zero + number);
        System.out.println((char) nine);
    }
}
