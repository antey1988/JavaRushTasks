package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {
        /*threads.get(4).start();
        threads.get(3).start();
        threads.get(2).start();
        threads.get(1).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threads.get(2).interrupt();
        threads.get(1).interrupt();
        ((Thread4)threads.get(3)).showWarning();*/
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
//                    sleep(500);
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            try {
                while (true) {
                    sleep(500);
                    System.out.println(getName());
                }
            } catch (InterruptedException e) {
            }
        }

        @Override
        public void showWarning() {
            if (isAlive()) interrupt();
        }
    }

    public static class Thread5 extends Thread {


        @Override
        public void run() {
            int sum = 0;
            int num;
            String string;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    string = reader.readLine();
                    if (string.equals("N")) {
                        System.out.println(sum);
                        return;
                    }
                    sum += Integer.parseInt(string);
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

        }
    }
}