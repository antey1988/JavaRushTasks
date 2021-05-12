package com.javarush.task.task29.task2912;

/* 
Рефакторинг паттерна Chain of Responsibility
*/

public class Solution {


    public static void main(String[] args) {

        Logger logger3 = new PhoneLogger(Level.FATAL);
        Logger logger2 = new SmsLogger(Level.ERROR);
        Logger logger1 = new ConsoleLogger(Level.WARN);
        Logger logger0 = new FileLogger(Level.INFO);

        logger0.setNext(logger1);
        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger0.inform("Everything is OK", Level.INFO);
        logger0.inform("We found a bug", Level.WARN);
        logger0.inform("Database connection error", Level.ERROR);
        logger0.inform("System shut down", Level.FATAL);
    }
}