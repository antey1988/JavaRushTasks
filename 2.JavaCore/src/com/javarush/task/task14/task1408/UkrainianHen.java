package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    public UkrainianHen() {
        countOfEggsPerMonth = 12;
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return countOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
