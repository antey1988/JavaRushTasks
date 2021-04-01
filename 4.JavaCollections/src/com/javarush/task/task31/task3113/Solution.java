package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Что внутри папки?
/home/oleg/Документы
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(br.readLine());
        if (Files.isRegularFile(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
        } else {
            List<Long> informatoin = Arrays.asList(new Long[]{0l, 0l, 0l});
            List<Path> list = new ArrayList<>();
            list = allFiles(path, informatoin);
            System.out.println("Всего папок - " + informatoin.get(0));
            System.out.println("Всего файлов - " + informatoin.get(1));
            System.out.println("Общий размер - " + informatoin.get(2));
        }
    }

    public static List<Path> allFiles (Path path, List<Long> informatoin) throws IOException {
        List<Path> list = new ArrayList<>();
        for (Path p : Files.list(path).collect(Collectors.toList())) {
            list.add(p);
            if (Files.isRegularFile(p)) {
                informatoin.set(1, informatoin.get(1) + 1);
                informatoin.set(2, informatoin.get(2) + Files.readAllBytes(p).length);
            } else {
                informatoin.set(0, informatoin.get(0) + 1);
                list.addAll(allFiles(p, informatoin));
            }
        }
        return list;
    }
}
