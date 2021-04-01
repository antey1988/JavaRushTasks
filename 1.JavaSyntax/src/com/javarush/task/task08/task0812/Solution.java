package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        List<Integer> numbers = new ArrayList<>();
        //List<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));

        }

        int maxlength = 1, currlength = 1;

        for (int i = 1; i < numbers.size() ; i++) {
            /*System.out.println(numbers.get(i));
            if ((int) numbers.get(i) == (int) numbers.get(i-1)) {++currlength;
                System.out.println(1); }
            else {
                currlength = 1;
                System.out.println(2);
            }*/
            currlength = ((int) numbers.get(i) == (int) numbers.get(i-1)) ? ++currlength : 1;

            if (currlength > maxlength) maxlength = currlength;
        }
        System.out.println(maxlength);
    }
}