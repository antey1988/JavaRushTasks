package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Exc.runexc1();
    }

    public void methodThrowsNullPointerException() {
        Exc.runexc2();
    }

    public static void main(String[] args) {
        new VeryComplexClass().methodThrowsClassCastException();
        new VeryComplexClass().methodThrowsNullPointerException();
    }
    private static class Exc {
        private static void runexc1() {
            throw new ClassCastException();
        }

        private static void runexc2() {
            throw new NullPointerException();
        }
    }
}
