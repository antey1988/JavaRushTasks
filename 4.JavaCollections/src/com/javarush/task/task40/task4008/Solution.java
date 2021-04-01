package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        boolean parseDate = false;
        boolean parseTime = false;
        String parser;
        if (date.contains(".") && date.contains(":")) {
            parser = "d.M.y H:m:s";
            parseDate = true;
            parseTime = true;
        } else if (date.contains(".")) {
            parser = "d.M.y";
            parseDate = true;
        } else {
            parser = "H:m:s";
            parseTime = true;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(parser);
        if (parseDate) {
            LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
            System.out.println("День: "+ localDate.getDayOfMonth());
            System.out.println("День недели: " + (localDate.getDayOfWeek().getValue()));
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.format(DateTimeFormatter.ofPattern("W")));
            System.out.println("Неделя года: " + localDate.format(DateTimeFormatter.ofPattern("w")));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (parseTime) {
            LocalTime localTime = LocalTime.parse(date, dateTimeFormatter);
            System.out.println("AM или PM: " + localTime.format(DateTimeFormatter.ofPattern("a")));
            System.out.println("Часы: " + localTime.format(DateTimeFormatter.ofPattern("K")));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
    }
}
