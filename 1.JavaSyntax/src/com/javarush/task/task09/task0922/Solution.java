package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String string = new BufferedReader(new InputStreamReader(System.in)).readLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(string);
        sdf = new SimpleDateFormat("MMM dd, yyyy", ENGLISH);
        //AUG 18, 2013
        System.out.println(sdf.format(date).toUpperCase());
    }
}
