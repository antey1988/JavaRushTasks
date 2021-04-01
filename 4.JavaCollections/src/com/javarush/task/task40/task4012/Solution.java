package com.javarush.task.task40.task4012;

import org.apache.commons.io.FileUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isLeap(LocalDate.parse("2020-01-01")));
        System.out.println(isLeap(LocalDate.parse("2021-01-01")));
        System.out.println(isBefore(LocalDateTime.parse("2021-01-01T00:00:00")));
        System.out.println(isBefore(LocalDateTime.parse("2021-05-01T00:00:00")));
        System.out.println(addTime(LocalTime.parse("00:00:00"), 5, ChronoUnit.HOURS).format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(addTime(LocalTime.parse("00:00:00"), 5, ChronoUnit.MINUTES).format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(getPeriodBetween(LocalDate.parse("2021-01-01"), LocalDate.now()));
        System.out.println(getPeriodBetween(LocalDate.parse("2020-02-01"), LocalDate.now()));

    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate))
            return Period.between(firstDate, secondDate);
        else
            return Period.between(secondDate, firstDate);
    }
}
