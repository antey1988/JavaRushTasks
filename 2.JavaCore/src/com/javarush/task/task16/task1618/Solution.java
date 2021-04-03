package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

import java.time.LocalDateTime;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread t = new TestThread();
        t.start();
        Thread.sleep(5000);
        t.interrupt();


    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        /*public TestThread(String testThread) {
            super(testThread);
        }*/

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println(LocalDateTime.now());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /*public static class TestThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println(LocalDateTime.now());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}