package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is == null) return sw;
        else {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String string;
            while ((string = br.readLine()) != null) {
                sw.write(string);
            }
        }
        return sw;
    }
}