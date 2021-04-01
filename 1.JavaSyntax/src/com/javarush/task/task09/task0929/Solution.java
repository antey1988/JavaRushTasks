package com.javarush.task.task09.task0929;

import java.io.*;

/*
Код не компилится…
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //InputStream fileInputStream;
        int i = 0;
        while (i < 2) {
            try {
                String sourceFileName = reader.readLine();
                InputStream fileInputStream = getInputStream(sourceFileName);
                String destinationFileName = reader.readLine();
                OutputStream fileOutputStream = getOutputStream(destinationFileName);

                //int count = 0;
                while (fileInputStream.available() > 0)
                {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data);
                    //count++;
                }

                //System.out.println("Скопировано байт " + count);

                fileInputStream.close();
                fileOutputStream.close();
                break;
            }
            catch (FileNotFoundException e) {
                System.out.println("Файл не существует.");
                i++;
            }
        }
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}
