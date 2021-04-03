package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String oldstring = string;
        int i = string.indexOf("\t");
        if (i == -1) throw new TooShortStringException();
        else {
            string = string.substring(i +1);
            int j = string.indexOf("\t");
            if (j == -1) throw new TooShortStringException();
            else return oldstring.substring(i + 1, i + 1 +j);
        }

    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(null));
    }
}
