package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        while (true) {
            int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            sum += i;
            if (i == -1) break;
        }
        System.out.println(sum);

    }
}
