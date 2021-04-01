package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge{
    public final int carCount = 2;
    @Override
    public int getCarsCount() {
        return carCount;
    }
}
