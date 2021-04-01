package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        for (String str : strings) {
            ids.add(shortener.getId(str));
        }
        Date stop = new Date();
        return stop.getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date stop = new Date();
        return stop.getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>(10000);
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> IdsShortener1 =  new HashSet<Long>();
        Set<Long> IdsShortener2 =  new HashSet<Long>();

        long timeShortener1 = getTimeToGetIds(shortener1, origStrings, IdsShortener1);
        long timeShortener2 = getTimeToGetIds(shortener2, origStrings, IdsShortener2);

        Assert.assertNotEquals(timeShortener1, timeShortener2);

        timeShortener1 = getTimeToGetStrings(shortener1, IdsShortener1, new HashSet<String>());
        timeShortener2 = getTimeToGetStrings(shortener2, IdsShortener2, new HashSet<String>());

        Assert.assertEquals(timeShortener1, timeShortener2, 100);
    }
}
