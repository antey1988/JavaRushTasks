package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public int countPasager;
    @Override
    public void fly() {

    }

    public Plane(int countPasager) {
        this.countPasager = countPasager;
    }
}
