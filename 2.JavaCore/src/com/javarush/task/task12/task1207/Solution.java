package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(5);
        print(new Integer(5));
    }

    public static void print(int i) {
        System.out.println(i + " метод с параметром типа int");
    }

    public static void print(Integer i) {
        System.out.println(i + " метод с параметром типа Integer");
    }
}
