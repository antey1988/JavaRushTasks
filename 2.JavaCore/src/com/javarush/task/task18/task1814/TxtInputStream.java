package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);
//        String str = fileName.substring(fileName.length() - 3);
//        boolean bool = !fileName.substring(fileName.length() - 3).equals("txt");
        if (!fileName.substring(fileName.length() - 4).equals(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
//        TxtInputStream txtis = new TxtInputStream("E:\\result.txt.mxt");
//        System.out.println("");
    }
}

