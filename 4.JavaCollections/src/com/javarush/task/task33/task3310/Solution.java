package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> Ids = new HashSet<>();
        for (String string : strings) {
            Ids.add(shortener.getId(string));
        }
        return Ids;
    }

    public  static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long id : keys) {
            strings.add(shortener.getString(id));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> TestSetStrings = new HashSet<>();
        int i = 0;
        while (i < elementsNumber) {
            TestSetStrings.add(Helper.generateRandomString());
            i++;
        }

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> Ids = getIds(shortener, TestSetStrings);
        Date stop = new Date();
        Helper.printMessage("" + (stop.getTime() - start.getTime()));

        start = new Date();
        Set<String> String = getStrings(shortener, Ids);
        stop = new Date();
        Helper.printMessage("" + (stop.getTime() - start.getTime()));

        boolean testgood = (TestSetStrings.containsAll(String) && String.containsAll(TestSetStrings));
        String string;
        if (testgood) string = "Тест пройден."; else string = "Тест не пройден.";
        Helper.printMessage(string);


    }

    public static void main(String[] args) {
        int count = 100;
        testStrategy(new HashMapStorageStrategy(), count);
        Helper.printMessage("");
        testStrategy(new OurHashMapStorageStrategy(), count);
        Helper.printMessage("");
        testStrategy(new FileStorageStrategy(), count);
        Helper.printMessage("");
        testStrategy(new OurHashBiMapStorageStrategy(), count);
        Helper.printMessage("");
        testStrategy(new HashBiMapStorageStrategy(), count);
        Helper.printMessage("");
        testStrategy(new DualHashBidiMapStorageStrategy(), count);
    }
}
