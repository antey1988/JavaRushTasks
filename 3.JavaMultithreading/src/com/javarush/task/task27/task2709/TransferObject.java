package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        try {
            while (!isValuePresent) {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        isValuePresent = false;
        System.out.println("Got: " + value);
        notifyAll();
        return value;
    }

    public synchronized void put(int value) {
        try {
            while (isValuePresent) {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        isValuePresent = true;
        this.value = value;
        System.out.println("Put: " + value);
        notifyAll();
    }
}
