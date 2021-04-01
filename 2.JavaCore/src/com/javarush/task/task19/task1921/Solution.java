package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String string;
        while ((string = br.readLine()) != null) {
            String[] words = string.split("\\s");
            int wordsLenght = words.length;
            Date date = new Date(
                    Integer.parseInt(words[wordsLenght - 1]) - 1900,
                    Integer.parseInt(words[wordsLenght - 2]) - 1,
                    Integer.parseInt(words[wordsLenght - 3]));
            String name = string.replaceAll("\\s\\d+","");
            PEOPLE.add(new Person(name, date));
        }
        br.close();
//        System.out.println("sfff fdfgfd  gd-5fds 123 34 45".replaceAll("\\s\\d+",""));
    }
}
