package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        //строки не начинаются с знака плюс, цифры или открывающейся скобки, лобо заканчивающиеся не цифрой
        /*if (!(telNumber.matches("^+.*")
                || telNumber.matches("^\\(.*")
                || telNumber.matches("^[0-9].*"))) return false;*/
        //строки содержат не цифры, кроме символов + ( ) -
        if (telNumber.matches(".*[^+()0-9-].*") || (telNumber.matches(".*[^0-9]$"))) return false;
        //строки с подряд стоящими -, либо с наличием их больше 3 штук
        if (telNumber.matches(".*-{2,}.*") ||
                telNumber.matches(".*(-\\d+){4,}") ||
                telNumber.matches(".*-.*\\(.*")) return false;
        if ((telNumber.matches(".*\\(.*") && !telNumber.matches(".*\\).*")) ||
                (telNumber.matches(".*\\).*") && !telNumber.matches(".*\\(.*")) ||
                telNumber.matches(".*\\).*\\(.*") ||
                telNumber.matches(".*\\({2,}.*") || telNumber.matches(".*\\){2,}.*") ||
                telNumber.matches(".*\\(\\d{0,2}\\).*") || telNumber.matches(".*\\(\\d{4,}\\).*")) return false;

        String string = telNumber.replaceAll("[+()-]","");
        if (telNumber.matches("^+.*"))
            if (string.length() == 12) return true;
            else return false;
        else
            if (string.length() == 10) return true;

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(checkTelNumber("(0)501234567"));
    }
}
