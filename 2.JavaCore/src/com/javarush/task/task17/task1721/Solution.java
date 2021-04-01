package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
/home/oleg/Документы/allLines.txt
/home/oleg/Документы/forRemoveLines.txt
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        String nameFirstFile = "", nameSecondFile = "", currentLine;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите имя первого файла");
            nameFirstFile = br.readLine();
            System.out.println("Введите имя второго файла");
            nameSecondFile = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(nameFirstFile));
            while ((currentLine = br.readLine()) != null) allLines.add(currentLine);
            br.close();
            br = new BufferedReader(new FileReader(nameSecondFile));
            while ((currentLine = br.readLine()) != null) forRemoveLines.add(currentLine);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        new Solution().joinData();
//        System.out.println("");
    }

    public synchronized void joinData() throws CorruptedDataException {

        List<String> list = new ArrayList<>(allLines);
        if (allLines.containsAll(forRemoveLines)) {
            for ( String s : forRemoveLines) list.remove(s);
            allLines = list;
        } else {
            list.clear();
            allLines = list;
            throw new CorruptedDataException();
        }

//        System.out.println("");

    }
}
