package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TestOrder extends Order {
    private static Random random = new Random();

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        int size = Dish.values().length;
        int count = random.nextInt(size) + 1;
        for (int i = 0; i < count; i++) {
            dishes.add(Dish.values()[random.nextInt(size)]);

        }
    }
}
