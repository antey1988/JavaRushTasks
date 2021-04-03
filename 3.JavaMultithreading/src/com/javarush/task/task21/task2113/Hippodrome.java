package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/*Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!

Пример:
Winner is Lucky!


Требования:
1. В классе Hippodrome должен быть создан метод getWinner без параметров.
2. В классе Hippodrome должен быть создан метод printWinner без параметров.
3. Метод getWinner должен возвращать лошадь пробежавшую наибольшую дистанцию.
4. Метод printWinner должен выводить на экран имя победителя на экран в формате заданном в условии задачи.*/

public class Hippodrome {

    public  static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Harlem", 3, 0);
        Horse horse2 = new Horse("Kazbek", 3, 0);
        Horse horse3 = new Horse("Dragun", 3, 0);
        List<Horse> horsesGame = game.getHorses();
        horsesGame.add(horse1);
        horsesGame.add(horse2);
        horsesGame.add(horse3);

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for(int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for(Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for(Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse horse_win = horses.get(0);
//        if (horses.size() == 1) return horse_win;
        for (int i = 1; i < horses.size(); i++) {
            Horse horse_cur = horses.get(i);
            if (horse_win.getDistance() < horse_cur.getDistance()) horse_win = horse_cur;
        }
        return horse_win;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
