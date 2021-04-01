package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.*;

/* 
Замена чисел
/home/oleg/Документы/task1924.txt
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static  {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        String string;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(string));

        while ((string = br.readLine()) != null) {
            /*String[] words = string.split("[\\s\\.]");
            Arrays.sort(words);
            List<Integer> list = new ArrayList<>();
            for(String s : words) {
//                s = s.replaceAll("\\.","");
                if (s.replaceAll("\\d", "").length() == 0) {
                    int i = Integer.parseInt(s);
                    if ((i < 13) && (i >= 0)) list.add(i);
                }

            }*/

            /*for(int i = list.size() - 1; i >= 0; i--) {
                string = string.replaceAll(" " + list.get(i).toString() + " ",
                        " " + map.get(list.get(i)) + " ");
                string = string.replaceAll("\\." + list.get(i).toString() + "\\s",
                        "." + map.get(list.get(i)) + " ");
                string = string.replaceAll("\\s" + list.get(i).toString() + "\\.",
                        " " + map.get(list.get(i)) + ".");
            }*/
            for(Map.Entry<Integer,String> entry : map.entrySet()) {
                string = string.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
            }
            System.out.println(string);
        }
        br.close();
    }
}
