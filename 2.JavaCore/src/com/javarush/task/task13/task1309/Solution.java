package com.javarush.task.task13.task1309;

/* 
1. Создай интерфейс CanMove с методом speed.
2. Метод speed должен возвращать значение типа Double и не должен ничего принимать в качестве аргументов.
3. Создай и унаследуй интерфейс CanFly от интерфейса CanMove.
4. Добавь в интерфейс CanFly метод speed.
5. Метод speed должен возвращать значение типа Double и принимать один параметр типа CanFly.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface CanMove {
        public Double speed();
    }

    public interface CanFly extends CanMove {
        public Double speed(CanFly param);
    }
}