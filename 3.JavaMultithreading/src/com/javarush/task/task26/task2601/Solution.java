package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {/*
        Integer[] array = {13, 8, 15, 5, 17, 14, 1, 1};
        sort(array);
        Arrays.stream(array).forEach(System.out::println);*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        double middle = (array[(array.length-1)/2] + array[(array.length)/2])/2.0;
        Arrays.sort(array, Comparator.comparingDouble((Integer o) -> Math.abs(o - middle)).thenComparingInt(o -> o));
        return array;
    }
}
