package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        String stroka = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int number = Integer.parseInt(stroka);
        if (number == 0) even++;
        else {
            number = (number >= 0) ? number : -number;
            //System.out.println(number);
            int raz = (int) Math.log10(number) + 1;
            //System.out.println(raz);

            for (int i = 0; i < raz; i++) {
                int a = number % 10;
                if (a % 2 == 0) even++;
                else odd++;
                number /= 10;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
