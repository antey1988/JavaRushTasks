package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
//        allPeople.add(Person.createMale("Сидоров Сидор", new Date()));  //сегодня родился    id=2
//        allPeople.add(Person.createMale("Юрьев Юрий", new Date()));  //сегодня родился    id=3
    }

    public static void main(String[] args) throws ParseException {
//        for (String arg : args) System.out.println(arg);


//        System.out.println(new Date()
        Date d;
        int i;
        int countPeople;
        SimpleDateFormat sdfForDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdfForString = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

//        for (Person person : allPeople) System.out.println(person.getName() + " "
//                + (person.getSex() == Sex.MALE ? "м" : "ж") + " "
//                + sdfForString.format(person.getBirthDate()));

        switch (args[0]) {
            case "-u":
                synchronized (allPeople) {
                    for (int j = 1; j < args.length; j += 4) {
                        try {
                            i = Integer.parseInt(args[j]);
                            d = sdfForDate.parse(args[3 + j]);
                            if (args[2 + j].equals("м"))
                                allPeople.set(i, Person.createMale(args[1 + j], d));
                            else if (args[2 + j].equals("ж"))
                                allPeople.set(i, Person.createFemale(args[1 + j], d));
                        } catch (ParseException e) {
                            System.out.println("Неверный формат даты");
                        }
                    }
                }
                break;
            case "-c":
                synchronized (allPeople) {
                    for (int j = 1; j < args.length; j += 3) {
                        try {
                            d = sdfForDate.parse(args[2 + j]);
                            //                    Person person = Person.createMale(args[1], d);
                            if (args[1 + j].equals("м"))
                                allPeople.add(Person.createMale(args[j], d));
                            else if (args[1 + j].equals("ж"))
                                allPeople.add(Person.createFemale(args[j], d));
                            System.out.println(allPeople.size() - 1);
                        } catch (ParseException e) {
                            System.out.println("Неверный формат даты");
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int j = 1; j < args.length; j++) {
                        try {
                            i = Integer.parseInt(args[j]);
                            allPeople.get(i).setAllValueNull();
                        } catch (NumberFormatException e) {

                        }
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int j = 1; j < args.length; j++) {
                        try {
                            i = Integer.parseInt(args[j]);
                            Person person = allPeople.get(i);
                            System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + sdfForString.format(person.getBirthDate()));
                        } catch (NumberFormatException e) {

                        }
                    }
                }
                break;
        }
//        for (Person person : allPeople) System.out.println(person.getName() + " "
//                + (Sex.MALE == person.getSex()  ? "м" : "ж") + " "
//                + sdfForString.format(person.getBirthDate()));
    }
}

