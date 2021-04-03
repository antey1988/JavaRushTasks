package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tomCat = new Cat("Tom", 30, 3);
        Dog tobikDog = new Dog("Tobik", 5, 7);
        /*System.out.println(jerryMouse.name + " " + jerryMouse.height + " " + jerryMouse.tail);
        System.out.println(tomCat.name + " " + tomCat.height + " " + tomCat.weight);
        System.out.println(tobikDog.name + " " + tobikDog.weight + " " + tobikDog.age);*/
        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat {
        String name;
        int height;
        int weight;

        public Cat(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }

    public static class Dog {
        String name;
        int age;
        int weight;

        public Dog(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }

    //напишите тут ваш код
}
