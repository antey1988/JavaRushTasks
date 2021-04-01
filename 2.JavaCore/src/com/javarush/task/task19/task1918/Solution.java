package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
/home/oleg/Документы/task1918.txt

*/

import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        /*String openTag = "<" + args[0];
        String closeTag = "</" + args[0];*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fbr = new BufferedReader(new FileReader(br.readLine()));
        br.close();

//        int rang = -1;
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(string);

        while ((string = fbr.readLine()) != null) {
            stringBuilder.append(string).append("\n");
        }
        fbr.close();
       /* StringBuilder string = new StringBuilder("Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela" +
                "</span><span>Turanga Leela\" +\n" +
                "                \"</span></b></span><span>Super</span><span>girl</span>\n" +
                "\n");
        System.out.println(string);*/
//        System.out.println(string.substring(50));

    //        String Tag = "span";
            String regex = "(<" + args[0] + "|" + "</" + args[0] +")";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(stringBuilder);

            Map<Integer, String > IndexAndTag = new TreeMap<>();

            while (matcher.find()) {
                int index = matcher.start();
                String tag = stringBuilder.substring(matcher.start(), matcher.end());
                IndexAndTag.put(index, tag);
            }

            int rang = 1;
            while(IndexAndTag.size() > 0) {
                Iterator<Map.Entry<Integer, String>> iter = IndexAndTag.entrySet().iterator();
                Map.Entry<Integer, String> firstElem = iter.next();
                int firstindes = firstElem.getKey();
                String firsttag = firstElem.getValue();

                while(iter.hasNext()) {
                    Map.Entry<Integer, String> Elem = iter.next();
                    int indes = Elem.getKey();
                    String tag = Elem.getValue();

                    if (!tag.equals(firsttag)) {
                        if (rang == 1) {
                            System.out.println(stringBuilder.substring(firstindes, indes + 1 + tag.length()));
                            IndexAndTag.remove(firstindes);
                            IndexAndTag.remove(indes);
                            break;
                        } else rang--;
                    } else rang++;
                }
            }
        /*String s = "fsfddff";
        System.out.println(s);
        System.out.println(s.length());
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder.length());
        stringBuilder = stringBuilder.append("\n");
        System.out.println(stringBuilder.length());*/
    }
}
