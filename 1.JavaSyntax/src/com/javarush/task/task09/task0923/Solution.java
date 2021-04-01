package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        String string = new BufferedReader(new InputStreamReader(System.in)).readLine();
        char[] array = string.toCharArray();
        String string_glass = "";
        String string_soglass = "";
        for (char i : array) {
            if (isVowel(i)) string_glass += " " + i;
            else if (i != ' ') string_soglass += " " + i;
        }
        System.out.println(string_glass + " ");
        System.out.println(string_soglass + " ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}