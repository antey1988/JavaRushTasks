package CalculatorBuilding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkWithDate {
    private WorkWithDate() {}

    public static int Raznost(LocalDate ld1, LocalDate ld2) {
        int totalDays = 0;
        if (ld1.getYear() != ld2.getYear()) {

            int dayToEndFirstYear = ld1.lengthOfYear() - ld1.getDayOfYear();
//            System.out.println(ld1.getYear() + " - " + dayToEndFirstYear);
            totalDays += dayToEndFirstYear;

            for (int i = ld1.getYear() + 1; i <= ld2.getYear() - 1; i++) {
                LocalDate ld = LocalDate.of(i, 1, 1);
//                System.out.println(ld.getYear() + " - " + ld.lengthOfYear());
                totalDays += ld.lengthOfYear();
                //            System.out.println(totalDays);
            }

            int dayToEndLastYear = ld2.getDayOfYear();
//            System.out.println(ld2.getYear() + " - " + dayToEndLastYear);
            totalDays += dayToEndLastYear;
        }
        else {
            totalDays = ld2.getDayOfYear() - ld1.getDayOfYear();
        }
//        System.out.println(totalDays);
        return totalDays;
    }

    public static LocalDate stringToDate(String string, String parser) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(parser);
        LocalDate ld = LocalDate.parse(string, dtf);
        return ld;
    }
}
