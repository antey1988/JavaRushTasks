package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order  {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        return dishes.stream().mapToInt(Dish::getDuration).sum();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("Your order: [");
        stringBuilder.append(dishes.get(0));
        for (int i = 1; i < dishes.size(); i++) {
            stringBuilder.append(", ").append(dishes.get(i));
        }
        stringBuilder.append("] of ").append(tablet);
        stringBuilder.append(String.format(", cooking time %dmin", getTotalCookingTime()));
        return stringBuilder.toString();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
