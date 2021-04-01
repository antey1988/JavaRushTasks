package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import javax.lang.model.element.NestingKind;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(baos);
        System.setOut(print);
        testString.printSomething();
        System.setOut(consoleStream);

        String string = baos.toString();
        int k = 0;
        String[] words = string.split("\\n");
        for (String s : words) {
            System.out.println(s);
            k++;
            if (k == 2) {
                System.out.println("JavaRush - курсы Java онлайн");
                k = 0;
            }
        }
//        System.out.print(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
