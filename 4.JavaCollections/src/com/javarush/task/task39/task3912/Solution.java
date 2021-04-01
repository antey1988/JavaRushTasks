package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {/*
        int[][] array1 = new int[][]{{1,1,1,0,0,0},
                                     {1,1,1,1,1,0},
                                     {1,1,1,1,1,0},
                                     {1,1,1,1,1,0},
                                     {1,1,1,1,1,0}};
        System.out.println(maxSquare(array1));
        int[][] array2 = new int[][]{{1,1,1},
                                    {1,1,1},
                                    {0,1,1}};
        System.out.println(maxSquare(array2));*/
    }

    /*public static int maxSquare(int[][] matrix) {
        int Square = 0;
        int maxMask = Math.min(matrix.length, matrix[0].length);
        boolean isFind = false;
        while (!isFind && maxMask>0) {
            for (int i = 0; i < matrix.length - maxMask + 1; i++) {
                for (int j = 0; j < matrix[0].length - maxMask + 1; j++) {
                    boolean isFill = isFillSquare(matrix, j, i, maxMask);
                    if (isFill) {
                        Square = maxMask*maxMask;
                        isFind = true;
                        break;
                    }
                }
                if (isFind)
                    break;
            }
            maxMask--;
        }
        return Square;
    }*/
    public static int maxSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] temp = new int[rows + 1][cols + 1];
        int maxLen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    temp[i][j] = Math.min(Math.min(temp[i][j - 1], temp[i - 1][j]), temp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, temp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
//    проверяет заполнена ли единицами подматрица, полученная размером l * l с верхинм левым углом в точке x, y
    /*private static boolean isFillSquare(int[][] matrix, int x, int y, int l) {
        long count = Arrays.stream(matrix).skip(y).limit(l)
                .flatMapToInt(array->Arrays.stream(array).skip(x).limit(l))
                .sum();
        return count == (long) l * l;
    }*/

}
