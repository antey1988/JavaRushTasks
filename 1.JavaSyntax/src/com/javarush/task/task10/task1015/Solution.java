package com.javarush.task.task10.task1015;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
//        ArrayList<String>[] arrayLists = (ArrayList<String>[]) new ArrayList[] {new ArrayList<String>(Arrays.asList("1","2")), new  ArrayList<String>(Arrays.asList("3","4"))};
        ArrayList<String>[] arrayLists = (ArrayList<String>[]) new ArrayList[2];
        arrayLists[0] = new ArrayList<String>(Arrays.asList("1","2"));
        arrayLists[1] = new  ArrayList<String>(Arrays.asList("3","4"));
        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}