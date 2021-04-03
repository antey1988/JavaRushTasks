package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

//import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        System.out.println(name + " получает " + n1 + " через " + n2 + " лет.");//напишите тут ваш код

    }
}
