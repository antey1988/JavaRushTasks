package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    /*public FileConsoleWriter (FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }*/

    public FileConsoleWriter (String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter (String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter (File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter (File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        /*char[] newbuf = Arrays.copyOfRange(cbuf, off, off + len);
        for (char c : newbuf) System.out.print(c);*/
        for (int i = off; i < off + len; i++) System.out.print(cbuf[i]);
        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.print(c);
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.print(str);
        fileWriter.write(str);
    }
    public void write(String str, int off, int len) throws IOException {
        String newstring = str.substring(off, off + len);
        System.out.print(newstring);
        fileWriter.write(str, off, len);
    }
    public void write(char[] cbuf) throws IOException {
        for (char c : cbuf) System.out.print(c);
        fileWriter.write(cbuf);
    }
    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
