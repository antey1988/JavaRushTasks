package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        Human grandFather1 = new Human("Petr", true, 89);
        humans.add(grandFather1);
        Human grandMother1 = new Human("Aksinya", false, 90);
        humans.add(grandMother1);
        Human grandFather2 = new Human("Grigoriy", true, 89);
        humans.add(grandFather2);
        Human grandMother2 = new Human("Nina", false, 82);
        humans.add(grandMother2);
        Human father = new Human("Aleksander", true, 57, grandFather1, grandMother1);
        humans.add(father);
        Human mother = new Human("Ludmila", false, 61, grandFather2, grandMother2);
        humans.add(mother);
        Human son = new Human("Oleg", true, 31, father, mother);
        humans.add(son);
        Human daugther1 = new Human("Olga", false, 33, father, mother);
        humans.add(daugther1);
        Human daugther2 = new Human("Yulia", false, 29, father, mother);
        humans.add(daugther2);

        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;
        
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}