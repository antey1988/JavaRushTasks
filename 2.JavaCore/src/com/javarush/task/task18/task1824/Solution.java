package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean Flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String string;
        while (Flag) {
            string = br.readLine();
            new ReadThread(string).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
        }

        @Override
        public void run() {
            ;
            try {
                InputStream fis = new FileInputStream(getName());
                BufferedInputStream bis = new BufferedInputStream(fis);
                bis.close();
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(getName());
                Flag = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
