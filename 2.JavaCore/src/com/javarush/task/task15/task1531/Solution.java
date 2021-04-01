package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(factorial(input));

        /*int i = 0;
        while (i <= input) {
        System.out.println(i + " : " + factorial(i)); i++;}*/
    }

    public static String factorial(int n) {
//        ArrayList<Integer> fact = Factorial(n);
//        String string = print(Factorial(n));
        String string = print(n);
        return string;
    }
/*
    public static String print(ArrayList<Integer> array) {
        String string = "";
        for (int i = array.size()-1 ; i >= 0 ; i--) {
            string += array.get(i);
        }
        return string;
    }

    private static ArrayList<Integer> Factorial(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n < 0) {
            list.add(0);
//            return  list;
        }
        else if ((n == 1) || (n == 0)) {
//            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
//            return  list;
        }
        else {
            list =  MultiNumberOnArrayList(n, Factorial(n - 1));
        }
        return  list;
    }

    private static ArrayList<Integer> MultiNumberOnArrayList(int n, ArrayList<Integer> list) {

        ArrayList<Integer> sumList = new ArrayList<>();
        int countRazrad = (int)Math.log10(n) + 1;
        int mnoj;

            for (int i = 0; i < countRazrad; i++) {
                ArrayList<Integer> prozList = new ArrayList<>();
                mnoj = n % 10;
                int perenos = 0;
                int proz = 0;

                for (int k = 0; k < list.size(); k++) {
                    proz = (list.get(k) * mnoj + perenos);
                    prozList.add(proz % 10);
                    perenos = proz / 10;
                }
                if (perenos >= 1) prozList.add(perenos);

                for (int j = 0; j < i; j++) {
                    prozList.add(0,0);
                }
//                System.out.println(print(prozList));

                sumList = SummaArraysList(sumList, prozList);

                n /= 10;
            }
//        System.out.println();
        return sumList;
    }

    private static ArrayList<Integer> SummaArraysList(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        ArrayList<Integer> listLonger, listShorter;
        ArrayList<Integer> list = new ArrayList<>();

        if ((list1.size() == 0) && (list2.size() == 0)) return list;
        if (list1.size() == 0) return list2;
        if (list2.size() == 0) return list1;

        listLonger = (list1.size() >= list2.size()) ? list1 : list2;
        listShorter = (list1.size() < list2.size()) ? list1 : list2;
        int perenos = 0;
        boolean flag = false;
        for (int i = 0; i < listLonger.size(); i++) {
            int k = 0;
            try {
                k = listShorter.get(i);
            } catch (IndexOutOfBoundsException e) {
                k = 0;
            }

            int sum = listLonger.get(i) + perenos + k;
            list.add(sum % 10);
            perenos = sum / 10;
        }
        if (perenos > 0) list.add(perenos);

        return list;
    }
*/
    private static String print(int n) {
        BigInteger bigInteger = new BigInteger(String.valueOf("1"));
        for (int i = 2; i <= n ; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        return bigInteger.toString();
    }
}
