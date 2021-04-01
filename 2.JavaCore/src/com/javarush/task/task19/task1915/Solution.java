package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        PrintStream ConsolStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        testString.printSomething();
//        String string = baos.toString();
        System.setOut(ConsolStream);
//        System.out.println(string.replaceAll("[^0-9]+", ""));
        FileOutputStream fos = new FileOutputStream(fileName);
        for (byte b : baos.toByteArray()){
            fos.write(b);
            System.out.print((char)b);
        }
        fos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

