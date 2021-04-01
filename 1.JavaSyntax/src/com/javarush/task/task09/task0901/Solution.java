package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //for(StackTraceElement i : ste) System.out.println(i.getMethodName());
        return  ste;
    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //for(StackTraceElement i : ste) System.out.println(i.getMethodName());
        return  ste;
    }

    public static StackTraceElement[] method3() {
        method4();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //for(StackTraceElement i : ste) System.out.println(i.getMethodName());
        return  ste;
    }

    public static StackTraceElement[] method4() {
        method5();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //for(StackTraceElement i : ste) System.out.println(i.getMethodName());
        return  ste;
    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //for(StackTraceElement i : ste) System.out.println(i.getMethodName());
        return  ste;
    }
}
