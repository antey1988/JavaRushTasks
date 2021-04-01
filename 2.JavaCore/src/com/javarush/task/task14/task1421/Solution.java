package com.javarush.task.task14.task1421;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Singleton
*/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(Singleton.getInstance());

        LocalDate ld1 = LocalDate.of(2018,10,28);
        LocalDate ld2 = LocalDate.of(2019,11,20);
        LocalDate ld3 = LocalDate.of(2019,01,20);
        List<LocalDate> list = new ArrayList<>(Arrays.asList(ld1, ld2, ld3));
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);



    }
}
