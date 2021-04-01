package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(fileName1));
        List<String> file1 = new ArrayList<>();
        String string;
        while ((string = br.readLine()) != null) file1.add(string);
        br.close();

        br = new BufferedReader(new FileReader(fileName2));
        List<String> file2 = new ArrayList<>();
        while ((string = br.readLine()) != null) file2.add(string);
        br.close();

        /*for (String s : file1) {
            if (file2.contains(s)) {
                lines.add(new LineItem(Type.SAME, s));
                file2.remove(s);
            } else lines.add(new LineItem(Type.ADDED, s));
        }

        for (String s : file2) {
            lines.add(new LineItem(Type.REMOVED, s));
        }*/
        int i = 0;
        while ((file1.size() > 0) && (file2.size() > 0)) {
            String line1 = file1.get(i);
            String line2 = file2.get(i);
            if (line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
                file1.remove(line1);
                file2.remove(line2);
            }
            else {
                String line3 = file1.get(i + 1);
                if (line3.equals(line2)) {
                    lines.add(new LineItem(Type.REMOVED, line1));
                    file1.remove(line1);
                    file1.remove(line3);
                    lines.add(new LineItem(Type.SAME, line2));
                    file2.remove(line2);
                } else {
                    String line4 = file2.get(i + 1);
                    if (line1.equals(line4)) {
                        lines.add(new LineItem(Type.ADDED, line2));
                        file2.remove(line2);
                        file2.remove(line4);
                        lines.add(new LineItem(Type.SAME, line1));
                        file1.remove(line1);
                    }
                }
            }
        }
        for (String s : file1) lines.add(new LineItem(Type.REMOVED, s));
        for (String s : file2) lines.add(new LineItem(Type.ADDED, s));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
