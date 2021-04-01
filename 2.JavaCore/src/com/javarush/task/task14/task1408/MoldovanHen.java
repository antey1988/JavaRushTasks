package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    public MoldovanHen() {
        countOfEggsPerMonth = 11;
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return countOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
