package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();



    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First video", 5000, 100, 3*60));
        add(new Advertisement(someContent, "Second video", 100, 10, 15*60));
        add(new Advertisement(someContent, "Third video", 400, 2, 10*60));
        add(new Advertisement(someContent, "Four video", 600, 3, 10*60 + 5));
    }

    public static AdvertisementStorage getInstance() {
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
