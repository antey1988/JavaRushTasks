package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ConsolStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
//        testString.printSomething();
        System.setOut(printStream);
        testString.printSomething();
        String string = baos.toString();
        String znak = string.replaceAll("[^\\+\\-\\*]", "");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        /*while (matcher.find()) {
            int a = Integer.parseInt(string.substring(matcher.start(), matcher.end()));
        }*/
        int a = 0, b = 0, c = 0;
        if (matcher.find()) a = Integer.parseInt(string.substring(matcher.start(), matcher.end()));
        if (matcher.find()) b = Integer.parseInt(string.substring(matcher.start(), matcher.end()));
//        String[] words = string.split("\\D??");
        System.setOut(ConsolStream);
        c = znak.equals("+") ? a + b : znak.equals("-") ? a - b : a * b;
        System.out.println(string.replaceAll("\\n", "") + c);
//        System.out.println(string + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

