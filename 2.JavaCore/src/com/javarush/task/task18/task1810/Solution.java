package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String name;
        FileInputStream inputStream;
        try {
            while (true) {
                name = br.readLine();
                inputStream = new FileInputStream(name);
                int count = inputStream.available();
                inputStream.close();
                if (count < 1000) {
//                    break;
                    throw new DownloadException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class DownloadException extends Exception {

    }
}
