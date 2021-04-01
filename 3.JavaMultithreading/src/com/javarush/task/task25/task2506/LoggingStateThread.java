package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = null;
        State newState;
        while ((newState = thread.getState()) != State.TERMINATED) {
            if (state != newState) {
                state = newState;
                System.out.println(newState);
            }
        }
        System.out.println(newState);
    }
}
