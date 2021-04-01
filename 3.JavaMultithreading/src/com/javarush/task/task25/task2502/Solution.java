package com.javarush.task.task25.task2502;

import java.util.*;
import java.util.stream.Collectors;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels hereloadWheelNamesFromDB()
            String[] strings = loadWheelNamesFromDB();
            if (strings.length != 4) throw new IllegalArgumentException();
            Set<Wheel> set = Arrays.stream(loadWheelNamesFromDB()).map(Wheel::valueOf).collect(Collectors.toSet());
            if (set.size() != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>(set);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
