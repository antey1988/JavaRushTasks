package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    private Solution(int a) {}
    Solution(short a) {}
    protected Solution(byte a) {}
    public Solution() {}

}

