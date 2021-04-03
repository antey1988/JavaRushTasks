package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//        System.out.println(getPartOfString("JavaRush"));
    }

    public static String getPartOfString(String string) {
//        System.out.println(string.indexOf(" "));
//        return string.substring(string.indexOf(" ") + 1);
        if (string == null) throw new TooShortStringException();
        String [] words = string.split("\\s");
        if (words.length < 5) throw new TooShortStringException();
        string = "";
        for (int i = 1; i < 5; i++) {
            string += " " + words[i];
        }
        return string.substring(1);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
