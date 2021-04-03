package com.javarush.task.task25.task2512;

import java.util.Deque;
import java.util.LinkedList;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Deque<Throwable> throwables = new LinkedList<>();
        Throwable throwable = e;
        do {
            throwables.push(throwable);
        } while ((throwable = throwable.getCause()) != null);

        while ((throwable = throwables.poll()) != null) {
            System.out.println(throwable.toString());
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            throw new RuntimeException("ABC", new Exception("DEF", new IllegalAccessException("GHI")));
        });
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
