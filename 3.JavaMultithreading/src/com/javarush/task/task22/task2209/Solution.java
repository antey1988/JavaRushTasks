package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
E:\task2209.txt
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        br.close();
        FileReader fr = new FileReader(string);
        br = new BufferedReader(fr);
        List<String> allWordsList = new ArrayList<>();
        while (((string = br.readLine()) != null)) {
            allWordsList.addAll(new ArrayList<>(Arrays.asList(string.split("\\s"))));
        }
        fr.close();
        br.close();
        //...
        String [] allWordsArray = allWordsList.toArray(new String[allWordsList.size()]);
        StringBuilder result = getLine(allWordsArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (words.length != 0) {

            List<List<String>> listsWords = new ArrayList<List<String>>();
            List<String> listWords = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                listWords.add(words[i]);
                List<String> list = new ArrayList<>(Arrays.asList(words[i]));
                listsWords.add(list);
            }
            //        int i = 0;
            //        int j = 1;
            for (int i = 0, j = 1; ((j < words.length) && (j != i)); ) {
                i = j;
                j = plusWord(listsWords, listWords);
            }

            for (String string : listsWords.get(0)) {
                stringBuilder.append(" ").append(string);
            }

            stringBuilder = new StringBuilder(stringBuilder.substring(1));

//            return stringBuilder;
        }
        return stringBuilder;
    }

    public static int plusWord(List<List<String>> listsWords, List<String> listWords) {
        List<List<String>> newlistsWords = new ArrayList<List<String>>();
        for (List<String> list : listsWords) {

            List<String> curwords = new ArrayList<>(listWords);
            for (String word : list) {
                if (curwords.contains(word)) curwords.remove(word);
            }

            String string1 = list.get(list.size()-1);
            String string2 = string1.substring(string1.length()-1);

            for (String word : curwords) {
                String string3 = word.substring(0,1);
                if (string2.equalsIgnoreCase(string3)) {
                    List<String> curlist = new ArrayList<>(list);
                    curlist.add(word);
                    newlistsWords.add(curlist);
                }
            }
        }

        if (newlistsWords.size() > 0) {
            listsWords.clear();
            listsWords.addAll(newlistsWords);
        }
        return listsWords.get(0).size();
    }
}
