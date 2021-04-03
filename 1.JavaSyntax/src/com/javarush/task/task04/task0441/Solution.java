package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());
        if (n1 > n2) {int n = n2; n2 = n1; n1 = n;}
        if (n1 > n3) {int n = n3; n3 = n1; n1 = n;}
        if (n2 > n3) {int n = n2; n2 = n3; n3 = n;}
        System.out.println(n2);
    }
}
