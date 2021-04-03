package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //System.out.println("введите свое имя");
        //String name = bufferedReader.readLine();
        //System.out.println("введите время в годах");
        String sTime = bufferedReader.readLine();
        int time = Integer.parseInt(sTime);
        String name = bufferedReader.readLine();

        System.out.println(name + " захватит мир через " + time + " лет. Му-ха-ха!");
        }//напишите тут ваш код

    }

