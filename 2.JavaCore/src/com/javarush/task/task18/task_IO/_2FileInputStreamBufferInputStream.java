package com.javarush.task.task18.task_IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;

public class _2FileInputStreamBufferInputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/home/oleg/Документы/test.txt");
        System.out.println(LocalTime.now());
        while (fileInputStream.available() > 0) {
            int i = fileInputStream.read();
        }
        System.out.println(LocalTime.now());
        fileInputStream.close();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/home/oleg/Документы/test.txt"));
        System.out.println(LocalTime.now());
        while (bufferedInputStream.available() > 0) {
            int i = bufferedInputStream.read();
        }
        System.out.println(LocalTime.now());
        bufferedInputStream.close();

    }


}
