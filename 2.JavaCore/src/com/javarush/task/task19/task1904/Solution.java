package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("E:\\result.txt"));
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        System.out.println(personScannerAdapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private  final  Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String string[] = fileScanner.nextLine().split("\\s");
            return new  Person(string[1], string[2], string[0], new Date(Integer.parseInt(string[5])-1900, Integer.parseInt(string[4])-1, Integer.parseInt(string[3])));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }

}
//    Person(string[0], string[1], string[2], new Date(Integer.parseInt(string[5]), Integer.parseInt(string[4]), Integer.parseInt(string[3]))