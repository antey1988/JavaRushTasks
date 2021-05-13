package com.javarush.task.task27.task2712;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Tablet tablet = tablets.get(new Random().nextInt(tablets.size()));
                tablet.createTestOrder();
                TimeUnit.MILLISECONDS.sleep(interval);
            }
        } catch (InterruptedException e) {

        }
    }
}
