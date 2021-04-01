package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (x < 0 || x >= image[0].length || y < 0 || y >= image.length) return false;

        Color oldColor = image[y][x];
        if (oldColor.equals(desiredColor)) return false;

        paintFill(image, x, y, oldColor, desiredColor);
        return true;
    }

    private boolean paintFill(Color[][] image, int x, int y, Color oldColor, Color newColor) {
        if (x < 0 || x >= image[0].length || y < 0 || y >= image.length) return false;
        if (image[y][x].equals(oldColor)) {
            image[y][x] = newColor;
            paintFill(image,x-1, y, oldColor, newColor);
            paintFill(image,x+1, y, oldColor, newColor);
            paintFill(image,x, y-1, oldColor, newColor);
            paintFill(image,x, y+1, oldColor, newColor);
        }
        return  true;
    }
}
