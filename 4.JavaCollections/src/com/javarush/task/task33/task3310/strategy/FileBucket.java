package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("temp", null);
            Files.deleteIfExists(path);
            Path newpath = Files.createFile(path);
            path.toFile().deleteOnExit();
//            Files.exists(path);
        } catch (IOException e) {

        }
    }

    public long getFileSize() {
        long size = 0;
        try {
            size = Files.size(path);
        } catch (IOException e) {

        }
        return size;
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
            oos.writeObject(entry);
        } catch (IOException e) {

        }

    }

    public Entry getEntry() {
        Entry entry = null;
        try {
            if (getFileSize() != 0) {
                ObjectInputStream oos = new ObjectInputStream(Files.newInputStream(path));
                entry = (Entry) oos.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {

        }
        return  entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        FileBucket fileBucket = new FileBucket();
    }
}
