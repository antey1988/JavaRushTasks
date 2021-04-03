package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a+b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        return 1.0*a/b;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return (double) a*b/100;
    }

    public static void main(String[] args) {
        System.out.println(plus(2, 3));
        System.out.println(minus(2, 3));
        System.out.println(multiply(2, 3));
        System.out.println(division(2, 3));
        System.out.println(percent(50, 5));
    }
}