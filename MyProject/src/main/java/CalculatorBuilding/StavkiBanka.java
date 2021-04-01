package CalculatorBuilding;

import java.time.LocalDate;

public class StavkiBanka {
    private LocalDate beginDate;
    private LocalDate endDate;
    private double percent;
    private int maxdays;

    public StavkiBanka(LocalDate beginDate, LocalDate endDate, float percent) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.percent = percent;
        this.maxdays = WorkWithDate.Raznost(beginDate, endDate);
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getPercent() {
        return percent;
    }

    public int getMaxdays() {
        return maxdays;
    }
}
