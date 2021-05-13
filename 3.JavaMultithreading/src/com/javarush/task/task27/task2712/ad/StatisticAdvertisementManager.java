package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private StatisticAdvertisementManager() {

    }

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    public List<Advertisement> getActiveVideoSet() {
        return storage.list().stream().filter(Advertisement::isActive).collect(Collectors.toList());
    }

    public List<Advertisement> getArchivedVideoSet() {
        return storage.list().stream().filter(a->!a.isActive()).collect(Collectors.toList());
    }
}
