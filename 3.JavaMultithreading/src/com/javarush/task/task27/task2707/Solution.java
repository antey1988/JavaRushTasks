package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        AtomicBoolean flag = new AtomicBoolean(false);
        Thread thread2 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (o2) {
                    flag.set(true);
                }
            }
        });
        thread2.setDaemon(true);
        thread2.start();
        Thread thread1 = new Thread(()->solution.someMethodWithSynchronizedBlocks(o1, o2));
        thread1.setDaemon(true);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return flag.get();
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
