package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
/home/oleg/Документы/task3101
/home/oleg/Документы/allFiles.txt
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, File> allFiles = new TreeMap<>();
        File path = new File(args[0]);
        File sourse = new File(args[1]);
        File destination = new File(sourse.getParent() + File.separator + "allFilesContent.txt");
        FileUtils.renameFile(sourse, destination);
        /*if (FileUtils.isExist(destination)) {
            FileUtils.deleteFile(destination);
            FileUtils.renameFile(sourse, destination);
        }*/
        addFiles(path, allFiles);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
            int i = 0;
            for (Map.Entry<String, File> entry : allFiles.entrySet()) {
                if (i++ != 0) bw.newLine();
                BufferedReader br = new BufferedReader(new FileReader(entry.getValue()));
                String str;
                int j = 0;
                while ((str = br.readLine()) != null) {
                    if (j++ != 0) bw.newLine();
                    bw.write(str);
                }
                br.close();
                //            fos.write("\n".getBytes());
            }
            bw.close();
        }
    }

    public static void addFiles(File path, Map<String, File> map) {
        for(File curFile : path.listFiles()) {
            if (curFile.isFile()) {
                if (curFile.length() <= 50) {
                    map.put(curFile.getName(), curFile);
                }
            } else {
                addFiles(curFile, map);
            }
        }
    }
}
