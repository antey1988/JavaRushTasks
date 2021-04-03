package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'



*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder("");
        String string1 = " and ";
        String string2 = " = '";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                stringBuilder.append(string1).append(entry.getKey()).append(string2).append(entry.getValue()).append("'");
            }
        }
        return stringBuilder.length() != 0 ? stringBuilder.substring(string1.length()) : "";
    }
}
