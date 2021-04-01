package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }
/*Вот вам диапазоны byte, которым соответствуют те или иные char:
a-z (маленькие буквы), диапазон: 97-122
A-Z (большие буквы), диапазон: 65-90
0-9 (цифра), диапазон: 48-57 😎*/
    public static ByteArrayOutputStream getPassword() {
        int lenpass = 15;
        String s;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lenpass; i++) {
                /*int FirstSym = 48 + (int)(Math.random() * 10);
                int SecondSym = 65 + (int)(Math.random() * 26);
                int ThirtSym = 97 + (int)(Math.random() * 26);*/

                int Sym;
                int code = (int)(Math.random() * 3);
                if (code == 0) Sym = 48 + (int)(Math.random() * 10);
                else if (code == 1) Sym = 65 + (int)(Math.random() * 26);
                else Sym = 97 + (int)(Math.random() * 26);

                sb = sb.append((char)Sym);
            }
            s = sb.toString();
//            if (s.matches("[^0-9a-zA-Z]")) continue;
            boolean a = s.matches(".*[0-9].*");
            boolean b = s.matches(".*[a-z].*");
            boolean c = s.matches(".*[A-Z].*");
            if (a && b && c) break;
        }
//        System.out.println(s);
        baos.write(s.getBytes(), 0, lenpass);
        return  baos;
    }
}