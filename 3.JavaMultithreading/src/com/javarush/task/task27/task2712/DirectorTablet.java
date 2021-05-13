package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Comparator;
import java.util.Map;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        long sum = 0;
        for (Map.Entry<String, Long> entry : StatisticManager.getInstance().getAdvertisementProfit().entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %.2f", entry.getKey(), 1.0 * entry.getValue()/100));
            sum += entry.getValue();
        }
        ConsoleHelper.writeMessage(String.format("%s - %.2f","Total", 1.0*sum/100));
    }
    public void printCookWorkloading() {
        for (Map.Entry<String, Map<String,Integer>> statisticDay : StatisticManager.getInstance().getCookWorkloading().entrySet()) {
            ConsoleHelper.writeMessage(statisticDay.getKey());
            for (Map.Entry<String, Integer> statisticCook : statisticDay.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min",statisticCook.getKey(), statisticCook.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet() {
        StatisticAdvertisementManager.getInstance().getActiveVideoSet().stream().sorted(Comparator.comparing(a->a.getName().toLowerCase()))
                .forEach(a->ConsoleHelper.writeMessage(String.format("%s - %d", a.getName(), a.getHits())));
    }
    public void printArchivedVideoSet() {
        StatisticAdvertisementManager.getInstance().getArchivedVideoSet().stream().sorted(Comparator.comparing(a->a.getName().toLowerCase()))
                .forEach(a->ConsoleHelper.writeMessage(a.getName()));
    }
}
