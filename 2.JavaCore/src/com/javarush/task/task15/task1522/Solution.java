package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        String planet = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        if (planet.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
        else if (planet.equals(Planet.MOON)) thePlanet = Moon.getInstance();
        else if (planet.equals(Planet.SUN)) thePlanet = Sun.getInstance();
        else thePlanet = null;
    }
}
