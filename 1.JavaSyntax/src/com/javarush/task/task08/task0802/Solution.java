package com.javarush.task.task08.task0802;

/* 
арбуз - ягода,
банан - трава,
вишня - ягода,
груша - фрукт,
дыня - овощ,
ежевика - куст,
жень-шень - корень,
земляника - ягода,
ирис - цветок,
картофель - клубень.

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String, String> maps= new HashMap<String, String>();
        maps.put("арбуз", "ягода");
        maps.put("банан", "трава");
        maps.put("вишня", "ягода");
        maps.put("груша", "фрукт");
        maps.put("дыня", "овощ");
        maps.put("ежевика", "куст");
        maps.put("жень-шень", "корень");
        maps.put("земляника", "ягода");
        maps.put("ирис", "цветок");
        maps.put("картофель", "клубень");

        for(Map.Entry<String, String> map : maps.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }

    }
}
