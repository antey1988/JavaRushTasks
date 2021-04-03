package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        List<Human> children = new ArrayList<>();
        Human son1 = new Human("oleg", true, 31, children);
        Human son2 = new Human("igor", true, 29, children);
        Human son3 = new Human("anton", true, 30, children);
        children = new ArrayList<>(Arrays.asList(son1, son2, son3));
        //children.addAll(Arrays.asList(son1, son2, son3));
        Human mother = new Human("Ludmila", false, 61, children);

        /*children.addAll(Arrays.asList(son1, son2, son3));
        mother.setChildrens(children);
        mother.setChildren(son1);
        mother.setChildren(son2);
        mother.setChildren(son3);*/
        Human father = new Human("Aleksander", true, 57, children);
        /*father.setChildren(son1);
        father.setChildren(son2);
        father.setChildren(son3);*/
        children = new ArrayList<>(Arrays.asList(mother));
        Human grandMother1 = new Human("Nina", false, 82, children);
//        grandMother1.setChildren(mother);
        Human grandFather1 = new Human("Grigoriy", true, 85, children);
        children = new ArrayList<>(Arrays.asList(father));
//        grandFather1.setChildren(mother);
        Human grandMother2 = new Human("Aksiniya", false, 90, children);
//        grandMother2.setChildren(father);
        Human grandFather2 = new Human("Petr", true, 95, children);
//        grandFather2.setChildren(father);

        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, List<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        /*public void setChildrens(List<Human> humans) {
            this.children = humans;
        }
        public void setChildren(Human human) {
            this.children.add(human);
        }*/



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
