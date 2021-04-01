package com.javarush.task.task14.task1408;

import sun.swing.CachedPainter;

public class RussianHen extends Hen {
    public RussianHen() {
       countOfEggsPerMonth = 10;
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return countOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
