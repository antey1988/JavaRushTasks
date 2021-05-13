package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    
    private static final StatisticManager instance = new StatisticManager();
    private final StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getAdvertisementProfit() {
        Map<String, Long> map = new TreeMap<>(Comparator.reverseOrder());

        for(EventDataRow event : statisticStorage.getVideoSelectedEventDataRow()) {
            VideoSelectedEventDataRow video = (VideoSelectedEventDataRow)event;
            String data = dateWithoutTime(video.getDate());
            map.put(data, map.computeIfAbsent(data, k->0L) + video.getAmount());
        }
        return map;
    }

    public Map<String, Map<String, Integer>> getCookWorkloading() {
        Map<String, Map<String, Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        for(EventDataRow event : statisticStorage.getCookedOrderEventDataRow()) {
            CookedOrderEventDataRow cookStatistic = (CookedOrderEventDataRow)event;
//            откидываем времменную часть даты из статистики, чтобы вести статистику в разрезе дней
            String data = dateWithoutTime(cookStatistic.getDate());
//            получаем карту отображения статистики за выбранный день, либо создаем новую с обратной сортировкой по дате
            Map<String, Integer> mapOfDay = map.computeIfAbsent(data, (k)->new TreeMap<>());
//            извлекаем имя повора из статистики
            String cookName = cookStatistic.getCookName();
            int timeCooking = mapOfDay.computeIfAbsent(cookName, (k)->0);
            mapOfDay.put(cookName, timeCooking+cookStatistic.getTime()/60);
        }
        return map;
    }

    private static String dateWithoutTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        return sdf.format(date);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getVideoSelectedEventDataRow() {
            return storage.get(EventType.SELECTED_VIDEOS);
        }

        private List<EventDataRow> getCookedOrderEventDataRow() {
            return storage.get(EventType.COOKED_ORDER);
        }
    }
}
