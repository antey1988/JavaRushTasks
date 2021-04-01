package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
/home/oleg/Документы/task1823_input0.txt
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String string;
        while (!(string = br.readLine()).equals("exit")) {
            new ReadThread(string).start();
        }
        br.close();
        /*for (Map.Entry<String,Integer> s :resultMap.entrySet()) {
            System.out.println(s.getKey() + " : " + s.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
        }

        @Override
        public void run() {
            int[] bytes = new int[256];
            try {
                InputStream fis = new FileInputStream(getName());
                BufferedInputStream bis = new BufferedInputStream(fis);
                while (bis.available() > 0) {
                    bytes[bis.read()]++;
                }
                bis.close();
                fis.close();
                int _bit = 0;
                for (int i = 1; i < bytes.length; i++) {
                    if (bytes[i] > bytes[_bit]) _bit = i;
                }
                resultMap.put(getName(), _bit);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }

    /*public static class ConsolInput extends Thread {
        @Override
        public void run() {

        }
    }*/
}
