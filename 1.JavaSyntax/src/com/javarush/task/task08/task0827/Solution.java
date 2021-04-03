package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {

        //System.out.println(ld);
        System.out.println(isDateOdd("MAY 1 2013"));

    }

    public static boolean isDateOdd(String date) throws ParseException {
        /*SimpleDateFormat dt = new SimpleDateFormat("MMMM d yyyy", ENGLISH);
        Date dates = dt.parse(date);
        LocalDateTime ld = LocalDateTime.ofInstant(dates.toInstant(), ZoneId.systemDefault());*/

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d yyyy", ENGLISH);
        //System.out.println(date.substring(0,1) + date.substring(1).toLowerCase());
        LocalDate ld = LocalDate.parse(date.substring(0,1) + date.substring(1).toLowerCase(), dtf);

        return ((ld.getDayOfYear() % 2) == 1);
    }
}
