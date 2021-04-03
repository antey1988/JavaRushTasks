package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (a > 0) {
            System.out.println(a*2);
        } else if (a < 0) {
            System.out.println(a+1);
        } else {
            System.out.println(a);
        }
    }

}