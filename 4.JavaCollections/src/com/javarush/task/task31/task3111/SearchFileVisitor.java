package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean flag = (maxSize == 0) || (content.length <= maxSize);
        flag = flag && ((minSize == 0) || (content.length >= minSize));
        flag = flag && ((partOfName == null) || (file.getFileName().toString().contains(partOfName)));
        flag = flag && ((partOfContent == null) || (containsString(file, partOfContent)));
        if (flag) foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    public static boolean containsString(Path file, String str) throws IOException {
        List<String> allString = Files.readAllLines(file);
        for (String string : allString) {
            if (string.contains(str)) return true;
        }
        return false;
    }
}
