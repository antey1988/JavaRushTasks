package com.javarush.task.task39.task3905;

import java.util.Random;

/* 
Залей меня полностью
*/

public class Solution {
    public static int width = 7;
    public static int height = 6;
    public static void main(String[] args) {
        int xColor = 2;
        int yColor = 2;
        Color cColor = Color.BLUE;

        Color[][] image = new Color[height][width];
        fillImage(image, xColor, yColor, cColor);
        printImage(image);

        System.out.println(new PhotoPaint().paintFill(image, width, 0, cColor));
        System.out.println(new PhotoPaint().paintFill(image, -1, 0, cColor));
        System.out.println(new PhotoPaint().paintFill(image, 0, height, cColor));
        System.out.println(new PhotoPaint().paintFill(image, 0, -1, cColor));
        System.out.println(new PhotoPaint().paintFill(image, xColor, yColor, cColor));
        System.out.println(new PhotoPaint().paintFill(image, xColor, yColor, Color.YELLOW));

        printImage(image);
    }

    private static void printImage(Color[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.printf("%8s", image[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static void fillImage(Color[][] image, int x, int y, Color color) {
        Color [] colors = Color.values();
        for (int i = 0; i < image[0].length; i++) {
            for (int j = 0; j < image.length; j++) {
                image[j][i] = colors[(int)(colors.length * Math.random())];
            }
        }
        image[y][x] = color;
    }
}
