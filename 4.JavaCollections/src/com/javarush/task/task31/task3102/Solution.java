package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Map<File, File> directory = new HashMap<>();
        List<File> firstList = Arrays.asList(new File(root).listFiles());
        List<String> listFiles = new ArrayList<>();
//        Queue<File> queue = new
        while (firstList.size() > 0) {
            List<File> secondList = new ArrayList<>();
            for (File file : firstList) {
                if (file.isFile()) {
                   /* String name = getFileParent(file.getParentFile(), directory) + file.getName();
                    listFiles.add(name);*/
                    listFiles.add(file.getAbsolutePath());
                } else {
                    secondList.addAll(Arrays.asList(file.listFiles()));
//                    directory.put(file, file.getParentFile());
                }
            }
            firstList = secondList;
        }
        return listFiles;
    }

    public static String getFileParent(File file,Map<File, File> map) {
        String str = "";
        if (map.containsKey(file)) str = getFileParent(map.get(file), map) + file.getName() + File.separator;
        return str;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("/home/oleg/Документы/task3101");
        System.out.println();
    }
}
