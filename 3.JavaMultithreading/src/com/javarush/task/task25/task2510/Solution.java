package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать".
2. Если это Exception, то вывести в консоль "Надо обработать".
3. Если это Throwable, то вывести в консоль "Поживем - увидим".
Реализуй эту логику.
*/

public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler((t, e)->{
            String print;
            if (e instanceof Error) System.out.println("Нельзя дальше работать");
            else if (e instanceof Exception) System.out.println("Надо обработать");
            else System.out.println("Поживем - увидим");
        });
    }

    @Override
    public void run() {
//        throw new Error();
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread thread = new Solution();
        thread.start();
    }
}
