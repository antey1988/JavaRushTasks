package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;
    int Age = 2;
    String Color = "black";
    int Weight = 3;

    public Cat(String name) {
        this.name = name;
        this.age = Age;
        this.weight = Weight;
        this.color = Color;
    }
    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = Color;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = Weight;
        this.color = Color;
    }
    public Cat(int weight, String color) {
        this.age = Age;
        this.weight = weight;
        this.color = color;
    }
    public Cat(int weight, String color, String address) {
        this.age = Age;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
