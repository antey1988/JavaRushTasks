package com.javarush.task.task18.task1826;

/* 
Шифровка
-e fileName fileOutputName
-d fileName fileOutputName


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream(args[1]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream fos = new FileOutputStream(args[2]);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        if (args[0].equals("-e")) {
            while ( (bis.available() > 0)) {
                bos.write(bis.read() + 1);
            }
        } else if (args[0].equals("-d")) {
            /*InputStream fis = new FileInputStream(args[2]);
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream fos = new FileOutputStream(args[1]);
            BufferedOutputStream bos = new BufferedOutputStream(fos);*/
            while ( (bis.available() > 0)) {
                bos.write(bis.read() - 1);
            }
            /*bos.close();
            bis.close();
            fos.close();
            fis.close();*/
        }
        bos.close();
        bis.close();
        fos.close();
        fis.close();
    }

}
