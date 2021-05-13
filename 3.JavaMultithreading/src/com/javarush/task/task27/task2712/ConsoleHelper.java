package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        String string;
        while (true) {
            writeMessage("Выберите блюдо из указанного списка: " + Dish.allDishesToString());
            string = readString();
            if (string.equals("exit"))
                break;

            boolean isNotFind = true;
            for (Dish dish:
                 Dish.values()) {
                if (string.equalsIgnoreCase(dish.toString())) {
                    list.add(dish);
                    isNotFind = false;
                    break;
                }
            }
            if (isNotFind) {
                writeMessage("Данного блюда нет в меню");
            }
        }
        return list;
    }
}
