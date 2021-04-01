package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.parseInt("fgdg");

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] i = new int[2];
            i[2]++;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> i = new ArrayList<>(2);
            i.get(2);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            InputStream i = new FileInputStream("gffdgfg");

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new _1Exceptiin());
        exceptions.add(new _2Exceptiin());
        exceptions.add(new _3Exceptiin());
        exceptions.add(new _4Exceptiin());
        exceptions.add(new _5Exceptiin());

    }

    static class _1Exceptiin extends Exception {
        public _1Exceptiin() {
            super("1 Exception");
        }
    }
    static class _2Exceptiin extends Exception {
        public _2Exceptiin() {
            super("2 Exception");
        }
    }
    static class _3Exceptiin extends Exception {
        public _3Exceptiin() {
            super("3 Exception");
        }
    }
    static class _4Exceptiin extends Exception {
        public _4Exceptiin() {
            super("4 Exception");
        }
    }
    static class _5Exceptiin extends Exception {
        public _5Exceptiin() {
            super("5 Exception");
        }
    }
}
