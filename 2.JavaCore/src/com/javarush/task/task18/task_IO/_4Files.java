package com.javarush.task.task18.task_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class _4Files {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 60; i++) {
            OutputStream fos = new FileOutputStream("/home/oleg/Документы/task1823_input" + i + ".txt");
            for (int j = 0; j < 100000; j++) {
                fos.write(i+50);
            }
            fos.close();
        }
    }
}
