package com.javarush.task.task08.task0810;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Время для 10 тысяч вызовов get
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getGetTimeInMs(fill(new ArrayList())));
        System.out.println(getGetTimeInMs(fill(new LinkedList())));
    }

    public static List fill(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        return list;
    }

    public static long getGetTimeInMs(List list) {
        LocalTime time1 = LocalTime.now();
        int s1 = time1.getSecond();
        int ms1 = time1.getNano()/1000000;

        get10000(list);

        LocalTime time2 = LocalTime.now();
        int s2 = time2.getSecond();
        int ms2 = time2.getNano()/1000000;

        return  ((s2 - s1) * 1000 + (ms2 - ms1));

    }

    public static void get10000(List list) {
        if (list.isEmpty()) {
            return;
        }
        int x = list.size() / 2;

        for (int i = 0; i < 10000; i++) {
            list.get(x);
        }
    }
}
