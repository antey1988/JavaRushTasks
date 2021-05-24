package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String digits;
        int module;
        if (s.startsWith("0x")) {
            digits = s.substring(2);
            module = 16;
        } else if (s.startsWith("0b")) {
            digits = s.substring(2);
            module = 2;
        } else if (s.startsWith("0")) {
            digits = s;
            module = 8;
        } else {
            digits = s;
            module = 10;
        }

        return String.valueOf(Integer.parseInt(digits, module));
    }
}
