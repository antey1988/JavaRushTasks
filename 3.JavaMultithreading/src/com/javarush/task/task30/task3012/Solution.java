package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(number)).append(" = ");
        int iter = 0;

        while (number > 0) {
            int q = number / 3;
            int r = number % 3;
            if (r == 0) {
                number = q;
                iter++;
            } else  if (r == 1) {
                int i = (int)Math.pow(3, iter++);
                number = q;
                stringBuilder.append(" + ").append(i);
            } else {
                int i = (int)Math.pow(3, iter++);
                number = q + 1;
                stringBuilder.append(" - ").append(i);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}