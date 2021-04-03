package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solution {
//    private static Object LocalDateTime;

    public static void main(String[] args) {
        String DT = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MM YYYY"));
        System.out.println(DT);
    }
}
