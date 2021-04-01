package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        /*for(RomanNum val : RomanNum.values()) {
            if (val.znak.equals(s)) return val.num;
        }
        return 0;*/
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;
        char [] symbol = s.toCharArray();
        int len = s.length() - 1;
        while (len >= 0) {
            if (len == 0) {
                sum += map.get("" + symbol[len]);
                break;
            } else {
                String str = "" + symbol[len - 1] + symbol[len];
                if (map.containsKey(str)) {
                    sum += map.get(str);
                    len -= 2;
                } else {
                    sum += map.get("" + symbol[len]);
                    len -= 1;
                }
            }
        }

        return sum;
    }

    /*private static class NumAndNearNum {
        private int num;
        private String znak;
        private static Map<String, NumAndNearNum> table = new HashMap<>();

        static {
            table.put("I", new NumAndNearNum(1 , "V"));
            table.put("V", new NumAndNearNum(1 , "V"));
            table.put("X", new NumAndNearNum(1 , "V"));
            table.put("L", new NumAndNearNum(1 , "V"));
            table.put("C", new NumAndNearNum(1 , "V"));
            table.put("D", new NumAndNearNum(500 , "C"));
            table.put("M", 1000);
        }

        public NumAndNearNum(int num, String znak) {
            this.num = num;
            this.znak = znak;
        }

        public static Map<String, NumAndNearNum> getTable() {
            return table;
        }
    }*/

    /*private  enum RomanNum {
        ODIN("I", 1), PYAT("V", 5), DECYAT("X", 10),
        PYATDECYAT("L", 50), STO("C", 100),
        PYATSOT("D", 500), TISYAZA("M", 1000);
        private String znak;
        private int num;

        RomanNum(String znak, int num) {
            this.znak = znak;
            this.num = num;
        }

        public String getZnak() {
            return znak;
        }

        public int getNum() {
            return num;
        }
    }*/
}
