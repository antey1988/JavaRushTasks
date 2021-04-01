package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
        OutputStream fos = new FileOutputStream("/home/oleg/Документы/task2014.txt");
        InputStream fis = new FileInputStream("/home/oleg/Документы/task2014.txt");

        Solution savedObject = new Solution(10);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedObject);
        oos.close();

        Solution loadedObject = new Solution(8);
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            loadedObject = (Solution) ois.readObject();
            ois.close();
            System.out.println(savedObject.string.equals(loadedObject.string));
        } catch ( ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) throws IOException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
