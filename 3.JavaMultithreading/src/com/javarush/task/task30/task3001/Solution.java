package com.javarush.task.task30.task3001;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        int module = number.getNumberSystem().getNumberSystemIntValue();
        String text = "";
        if (module == 12) {
            text = "ab";
        }
        if (module == 16) {
            text = "a-f";
        }
        String mask = String.format(".*[^0-%d%s].*", module > 10 ? 9 : module -1, text);
        System.out.println(mask);

        if (number.getDigit().matches(mask)) {
            throw  new NumberFormatException();
        }

        BigInteger digits = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
//        System.out.println(digits);
        StringBuilder stringBuilder = new StringBuilder();

        Map<Integer, String> codes = new HashMap<>();
        codes.put(0,"0");
        codes.put(1,"1");
        codes.put(2,"2");
        codes.put(3,"3");
        codes.put(4,"4");
        codes.put(5,"5");
        codes.put(6,"6");
        codes.put(7,"7");
        codes.put(8,"8");
        codes.put(9,"9");
        codes.put(10, "a");
        codes.put(11, "b");
        codes.put(12, "c");
        codes.put(13, "d");
        codes.put(14, "e");
        codes.put(15, "f");

        BigInteger n1, n2;
        BigInteger divider = BigInteger.valueOf(expectedNumberSystem.getNumberSystemIntValue());
        do {
            n1 = digits.divide(divider);
            n2 = digits.subtract(n1.multiply(divider));
            stringBuilder.append(codes.get(n2.intValue()));
            digits = n1;
        } while (digits.compareTo(BigInteger.ZERO) > 0);

        return new Number(expectedNumberSystem, stringBuilder.reverse().toString());
//        return new Number(NumberSystemType._2, "11");
    }
}
