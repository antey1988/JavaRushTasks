package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> rezult = new ArrayList<>();

        for (String string : strings) {
            boolean isR = false, isL = false;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == (char) 'р') isR = true;
                if (string.charAt(i) == (char) 'л') isL = true;
                ;
            }
            /*System.out.println(isR + " " + isL);
            System.out.println();*/

            if ((isL && isR) || (!isL && !isR)) {
                rezult.add(string);
                //System.out.println("1");
            }
            if (isL && !isR) {
                rezult.add(string);
                rezult.add(string);
                //System.out.println("2");
            }
        }
        return rezult;
    }
}