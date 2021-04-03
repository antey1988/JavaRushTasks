package CalculatorBuilding;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

///home/oleg/Документы/test.txt
public class
Raschet {

    public static void main(String[] args) throws IOException {
        final double DEFULTSTAVKA = 10.0; //ставка по умолчанию
        final double AMONTKVARTIRA = 1_900_000; //цена квартиры по умолчанию
        final LocalDate DEFULTBEGINDATE = LocalDate.of(2016, 01, 31);

        Map<LocalDate, Double> zapisi = new HashMap<>(); //Записи процентной ставки рефинансирования
        double stavka;//Ставка текущего интервала
        double dolg = 0;

        int totalDay = 0;
        LocalDate beginDate, endDate; //начальная и конечная даты расчетного периода

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Считываем начальню дату расчетного периода, дата вводится в указанном формате.
        //Если введена пустая строка используется дата по умолчанию
        System.out.println("Введите начальную дату периода расчета в формате dd.MM.yyyy" + "\n" +
                "или нажмите Enter для использования даты по умолчанию " + DEFULTBEGINDATE);
        while (true) {
            try {
                String string = br.readLine();
                if (string.isEmpty()) beginDate = DEFULTBEGINDATE;
                else beginDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Не корректное значение даты. Введите повторно в формате dd.MM.yyyy");
            }
        }

        //Считываем конечную дату расчетного периода, дата вводится в указанном формате.
        //Если введена пустая строка используется текущая дата
        //Проверяем,чтобы конечная дата была позже начально, иначе требуем ввести корректное значение
        System.out.println("Введите конечную дату периода расчета в формате dd.MM.yyyy" + "\n" +
                "или нажмите Enter для использования текущей даты");
        while (true) {
            try {
                String string = br.readLine();
                if (string.isEmpty()) endDate = LocalDate.now();
                else {
                    endDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    if (endDate.isBefore(beginDate)) {
                        System.out.println("Конечная дата не может быть меньше начальной. " +
                                "Введите новое значение");
                        continue;
                    }
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Не корректное значение даты. Введите повторно в формате dd.MM.yyyy");
            }
        }


        //Расчет долга застройщика
        //
        if (endDate.isEqual(beginDate)) System.out.println("Долг застройщика составляет " + 0 + " рублей");
        else {
            try {
                //Из файла формируем карту с записями процентной ставки рефинансирования
                zapisi = MapFromFile();
                stavka = DEFULTSTAVKA;
                LocalDate oldDate = beginDate;  //переменная для хранения первичной даты периода
                                                //пока она не попадет в интервал записи
                                                //или начальной даты интервала предыдущей записи
                LocalDate newDate;              //начальная дата текущей записи

                SortedSet<LocalDate> sortedSet = new TreeSet<>(zapisi.keySet());//отсортированное по возрастанию даты
                Iterator<LocalDate> iter = sortedSet.iterator();                //множество записей

                while (iter.hasNext()) {
                    newDate = iter.next();
                    //если начальная дата расчетного периода меньше даты текущей записи
                    //начинается начислений за данный интервал
                    if (oldDate.isBefore(newDate)) {
                        //выполняется для отрезка от начальной даты расчетного периода до
                        //начальной даты интервала, в который попадет конечная дата расчетного периода
                        if (newDate.isBefore(endDate)) {
                            int countDay = WorkWithDate.Raznost(oldDate, newDate);//колчисетво дней
                            totalDay += countDay;
                            double sum = Math.round(AMONTKVARTIRA * countDay * 2 * stavka / 300) / 100.0;//долго за указанное количество дней

                            System.out.println("начало периода - " + oldDate + "|  конец периода - " + newDate +
                                    "|  ставка - " + stavka +  "|  количество дней - " + countDay +
                                    "|  сумма неустойки - " + sum);
                            dolg += sum;//увеличиваем суммарный долг
//                            System.out.println(dolg);
                            stavka = zapisi.get(newDate);//новое значение ставки для следующего расчета
                            oldDate = newDate;//текущуюдату присваем старому значению
                        }
                        //выполняется для отрезка от начальной даты последнего интервала,
                        //в который попала конечная дата расчетного преиода до этой даты
                        else {
                            int countDay = WorkWithDate.Raznost(oldDate, endDate);//колчество дней
                            totalDay += countDay + 1;
                            double sum = Math.round(AMONTKVARTIRA * (countDay + 1) * 2 * stavka / 300) / 100.0;//вел
                            System.out.println("начало периода - " + oldDate + "|  конец периода - " + endDate +
                                    "|  ставка - " + stavka +  "|  количество дней - " + (countDay +1) +
                                    "|  сумма неустойки - " + sum);
                            dolg += sum;
                            System.out.println();
                            break;//прерывает расчет для оставшихся интервалов
                        }
                    }
                    //если начальная дата расчетного периода больше или равна начальной
                    //дате интервала прсваем новое значение ставки и продолжаем расчет
                    else {

                        stavka = zapisi.get(newDate);
//                        System.out.println(1 + " - " + stavka);
                        continue;
                    }
                }

            } catch (NullPointerException e) {
                System.out.println("Файл не содержит записей, будет использовано значение ставки по умолчанию");
//                System.out.println(WorkWithDate.Raznost(beginDate, endDate));
                dolg = (double) Math.round(AMONTKVARTIRA * WorkWithDate.Raznost(beginDate, endDate) * 2 * DEFULTSTAVKA /  300) / 100;
//                System.out.println("долг застройщика составляет " + dolg + " рублей");
            }
            dolg = Math.round(dolg *100) / 100.0;
            double poldolg = (int)(dolg * 100 / 2) / 100.0;
            System.out.println("Общее количество дней просрочки :" +  totalDay);
            System.out.println("Долг застройщика составляет " + dolg  + " рублей");
            System.out.println("Штраф застройщика составляет " + poldolg + " рублей");
            System.out.println("Суммарная выплата застройщика составляет " + (10000 + dolg + poldolg) + " рублей");
        }


    }
    public static List<StavkiBanka> MapToArrayList(Map<LocalDate, Float> map) throws IOException {

        List<StavkiBanka> stavkiBanka = new ArrayList<>();

        SortedSet<LocalDate> sortedSet = new TreeSet<>(map.keySet());
        Iterator<LocalDate> iter = sortedSet.iterator();
        if (iter.hasNext()) {
            LocalDate _old = iter.next();
            LocalDate _new;
            while (iter.hasNext()) {
                _new = iter.next();
                stavkiBanka.add(new StavkiBanka(_old, _new, map.get(_old)));
                _old = _new;
            }
            stavkiBanka.add(new StavkiBanka(_old, LocalDate.now(), map.get(_old)));
        }
        return stavkiBanka;
    }

    public static  Map<LocalDate, Double> MapFromFile() throws IOException {
        final String PARSER = "dd.MM.yyyy";
//        System.out.println("Введите название файла со значениями ставок рефинансирования");
//        BufferedReader filename = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(filename);

//        String name = filename.readLine();
        String name = "/home/oleg/Документы/test1.txt";
//        BufferedReader br;
//        FileReader fr;

        Map<LocalDate, Double> zapisi = new HashMap<>();

        try {
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line.isEmpty()) break;
                String[] words = line.split("\\s");
                LocalDate ld = LocalDate.parse(words[0], DateTimeFormatter.ofPattern(PARSER));
                double percent = Float.parseFloat(words[1].replace(',','.'));
                zapisi.put(ld, percent);
            }
            zapisi.put(LocalDate.now(), 0.0);
            br.close();
            fr.close();
//            System.out.println(zapisi);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не существует");
        }
//        filename.close();
        return zapisi;
    }
}
