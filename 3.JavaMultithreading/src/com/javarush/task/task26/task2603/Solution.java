package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {
        List<People> peoples = new ArrayList<>();
        peoples.add(new People("Oleg", "Petrov", 31, 185, 85));
        peoples.add(new People("Oleg", "Petrov", 32, 180, 88));
        peoples.add(new People("Igor", "Petrov", 32, 175, 80));
        peoples.add(new People("Oleg", "Ivanov", 33, 175, 85));
        peoples.add(new People("Sergey", "Sidorov", 31, 165, 80));

        Comparator<People> c1 = Comparator.comparing(People::getName);
        Comparator<People> c2 = Comparator.comparing(People::getSurname);
        Comparator<People> c3 = Comparator.comparingInt(People::getAge);
        Comparator<People> c4 = Comparator.comparingInt(People::getHeight);

        Comparator[] vararg = {c4, c1};
        /*vararg[0] = c4;
        vararg[1] = c3;
        vararg[2] = c2;
        vararg[3] = c1;*/

        peoples.sort(new CustomizedComparator<People>(vararg));
        peoples.forEach(System.out::println);
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T> [] comparators;

        public CustomizedComparator(Comparator<T> ... vararg ) {
            this.comparators = vararg ;
        }

        @Override
        public int compare(T o1, T o2) {
            int comp = 0;
            for (int i = 0; i < comparators.length; i++) {
                comp = comparators[i].compare(o1, o2);
                if (comp != 0)  return comp;
            }
            return comp;
        }
    }

    public static class People {
        private String name;
        private String Surname;
        private int age;
        private int height;
        private int weight;

        public People(String name, String surname, int age, int height, int weight) {
            this.name = name;
            Surname = surname;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return Surname;
        }

        public int getAge() {
            return age;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", Surname='" + Surname + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }
}
