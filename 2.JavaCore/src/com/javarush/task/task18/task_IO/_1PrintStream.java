package com.javarush.task.task18.task_IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*printStream.println("Hello!");
       printStream.println("We are robots!");

       printStream.printf(GREETINGS_MESSAGE, "Amigo", 18);
       printStream.printf(GREETINGS_MESSAGE, "R2-D2", 35);
       printStream.printf(GREETINGS_MESSAGE, "C-3PO", 35);

       printStream.close();
       */

public class _1PrintStream {
    private static final String GREETINGS_MESSEGE = "My name is %s, my age is %d!";

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream("/home/oleg/Документы/test.txt");
        printStream.println("Hello!");
        printStream.println("We are robots!");
        for (int i = 0; i < 200; i++) {
            printStream.printf(GREETINGS_MESSEGE, "Amigo", i);
            printStream.println("");
            printStream.printf(GREETINGS_MESSEGE, "R1-D2", i);
            printStream.println("");
        }
        printStream.close();

    }
}
