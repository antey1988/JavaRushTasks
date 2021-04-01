package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
E:\result.txt.part1
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String fileName = null, string;
        Map<String, byte[]> files = new TreeMap<>();
        boolean flag = true;
        /*files.put(1,5);
        files.put(5,8);
        files.put(0,9);
        for (Map.Entry<Integer,Integer> entry : files.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/
        Pattern pattern = Pattern.compile("part\\d+");
        /*String s = "dfsdfdfsff.sdfsfsf.part43";
        Matcher matcher1 = pattern.matcher(s);
        if (matcher1.find()) {
            System.out.println(s.substring(matcher1.start()));
            System.out.println(s.substring(0, matcher1.start() - 1));
        }*/
//        Pattern pattern = Pattern.compile("\\d+");
        while (!(string = br.readLine()).equals("end")) {
            try {
                InputStream fis = new FileInputStream(string);
                BufferedInputStream bis = new BufferedInputStream(fis);
                Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    byte[] bytes = new byte[bis.available()];
                    bis.read(bytes);
                    files.put(string.substring(matcher.start()), bytes);
                    if (flag) {
                        flag = false;
                        fileName = string.substring(0, matcher.start() - 1);
                    }
                }
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        try {
        OutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (Map.Entry<String, byte[]> entry : files.entrySet()) {
            bos.write(entry.getValue());
        }
        bos.close();
        fos.close();
        

 /*   public static class ReadThread extends Thread {
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
*/
        // implement file reading here - реализуйте чтение из файла тут
    }
}
