package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        int[] lenarrays = {5, 2, 4, 7, 0};
        ArrayList<int[]> list = new ArrayList<>(5);
        for (int i : lenarrays) {
            int[] array = new int[i];
            for (int j = 0; j < i; j++) {
                array[j] = j * i;
            }
            list.add(array);
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
