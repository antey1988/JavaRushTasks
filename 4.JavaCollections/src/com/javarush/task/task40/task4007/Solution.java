package com.javarush.task.task40.task4007;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        boolean printDate = false;
        boolean printTime = false;
        String parseDatetime = "";
        if (date.contains(".")) {
            parseDatetime = "dd.MM.yyyy";
            printDate = true;
        }
        if (date.contains(":")) {
            if (printDate) parseDatetime +=" ";
            parseDatetime += "HH:mm:ss";
            printTime = true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(parseDatetime);

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));

            if (printDate) {
                System.out.println("День: " + calendar.get(Calendar.DATE));
                System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
            }
            if (printTime) {
                System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == Calendar.PM ? "PM" : "AM"));
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
