package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
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

    public void initialize(String name) {
        this.name = name;
        this.age = Age;
        this.weight = Weight;
        this.color = Color;
    }
    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = Color;
    }
    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = Weight;
        this.color = Color;
    }
    public void initialize(int weight, String color) {
        this.age = Age;
        this.weight = weight;
        this.color = color;
    }
    public void initialize(int weight, String color, String address) {
        this.age = Age;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
