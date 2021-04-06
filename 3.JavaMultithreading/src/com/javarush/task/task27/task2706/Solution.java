package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        Object ob1, ob2, ob3 = new Object();
        if (obj1.hashCode() - obj2.hashCode() < 0) {
            ob1 = obj1;
            ob2 = obj2;
        } else  {
            ob1 = obj2;
            ob2 = obj1;
        }
        synchronized (ob1) {
            longTimeMethod();
            synchronized (ob2) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }

}
