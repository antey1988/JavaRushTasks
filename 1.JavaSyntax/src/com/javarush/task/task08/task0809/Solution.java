package com.javarush.task.task08.task0809;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.*;

/* 
Время для 10 тысяч вставок
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getInsertTimeInMs(new ArrayList()));
        System.out.println(getInsertTimeInMs(new LinkedList()));
    }

    public static long getInsertTimeInMs(List list){
        LocalTime time1 = LocalTime.now();
        int s1 = time1.getSecond();
        int ms1 = time1.getNano()/1000000;

        insert10000(list);

        LocalTime time2 = LocalTime.now();
        int s2 = time2.getSecond();
        int ms2 = time2.getNano()/1000000;

        return  ((s2 - s1) * 1000 + (ms2 - ms1));

    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
            //list.add(new Object());
        }
    }
}
