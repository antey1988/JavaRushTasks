package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int a = 0;
        if (this.age > anotherCat.age) a++; else if (this.age < anotherCat.age) a--;
        if (this.weight > anotherCat.weight) a++; else if (this.weight < anotherCat.weight) a--;
        if (this.strength > anotherCat.strength) a++; else if (this.strength < anotherCat.strength) a--;
        return a > 0;
    }

    public static void main(String[] args) {
        /*Cat cat1 = new Cat();
        cat1.age = 3;
        cat1.weight = 2;
        cat1.strength = 3;

        Cat cat2 = new Cat();
        cat2.age = 2;
        cat2.weight = 3;
        cat2.strength = 2;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));*/
    }
}
