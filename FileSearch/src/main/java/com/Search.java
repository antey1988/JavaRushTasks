package com;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Date;

public class Search {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) throw new IllegalArgumentException("Не верное количестко агрументов");
        String rootPath = args[0];
        String mask = args[1];

        File rootDirectory = new File(rootPath);
        if (!rootDirectory.exists()) throw new FileNotFoundException();
        if (!rootDirectory.isDirectory()) throw new IllegalArgumentException("Указанный файл не является директорией");
        Date date = new Date();
        printFilesByMask(rootDirectory, mask);
    }

    private static void printFilesByMask(File directory, String mask) {
        for (File file : directory.listFiles(new MyFileNameFilter(mask))) {
            System.out.println(file.getAbsolutePath());
        }
        for (File file : directory.listFiles(new MyFileFilter())) {
            printFilesByMask(file, mask);
        }
    }

    private static class MyFileNameFilter implements FilenameFilter {
        private String ext;

        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }

    private static class MyFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    }
}
