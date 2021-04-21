package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static final AtomicInteger priority = new AtomicInteger(MIN_PRIORITY-1);

    public MyThread() {
        setPriority(priority());
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(priority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(priority(priority()));
    }

    public MyThread(String name) {
        super(name);
        setPriority(priority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(priority(priority()));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(priority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(priority(priority()));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(priority(priority()));
    }

    private static int priority() {
        if (priority.incrementAndGet() > MAX_PRIORITY)
            priority.set(MIN_PRIORITY);
        return priority.get();
    }

    private static int priority(int priority) {
        return Math.min(priority, currentThread().getThreadGroup().getMaxPriority());
    }
}
