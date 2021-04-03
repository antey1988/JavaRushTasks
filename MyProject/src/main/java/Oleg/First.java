package Oleg;

import java.util.Random;

public class First {
    public static void main(String[] args) {
        Recursion(0.1);
        Random rnd = new Random();
        System.out.println(rnd);
        System.out.println(rnd.nextInt(100));
        System.out.println(rnd.nextInt(1));

    }

    public static void Recursion(double x) {
        if (x <= 0) return;
        System.out.println(x);
        Recursion(x-1);
    }


}
