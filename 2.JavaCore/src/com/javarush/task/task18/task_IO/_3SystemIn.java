package com.javarush.task.task18.task_IO;

import java.io.*;

public class _3SystemIn {
    public static void main(String[] args) throws IOException {
        String greetings = "Привет! Меня зовут Амиго!\nЯ изучаю Java на сайте JavaRush.\nОднажды я стану крутым программистом!\n";
        byte[] bytes = greetings.getBytes();

        InputStream inputStream = new ByteArrayInputStream(bytes);

        System.setIn(inputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while ((str = reader.readLine())!= null) {

            System.out.println(str);
        }
    }
}
