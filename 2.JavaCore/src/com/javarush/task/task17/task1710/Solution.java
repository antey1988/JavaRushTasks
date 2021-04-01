package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
//        for (String arg : args) System.out.println(arg);
        /*for (Person person : allPeople) System.out.println(person.getName() + " "
                + (person.getSex() == Sex.MALE ? "м" : "ж") + " "
                + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));*/

//        System.out.println(new Date()
        Date d;
        int i;
        switch (args[0]) {
            case "-u":
                try {
                    i = Integer.parseInt(args[1]);
                    d = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]);
                    if (args[3].equals("м")) allPeople.set(i, Person.createMale(args[2], d));
                    else if (args[3].equals("ж")) allPeople.set(i, Person.createFemale(args[2], d));
                } catch (ParseException e) {
                    System.out.println("Неверный формат даты");
                }
                break;
            case "-c":
                try {
                    d = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]);
//                    Person person = Person.createMale(args[1], d);
                    if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], d));
                    else if (args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], d));
                    System.out.println(allPeople.size() - 1);
                } catch (ParseException e) {
                    System.out.println("Неверный формат даты");
                }
                break;
            case "-d":
                try {
                    i = Integer.parseInt(args[1]);
                    allPeople.get(i).setAllValueNull();
                } catch (NumberFormatException e) {

                }
                break;
            case "-i":
                try {
                    i = Integer.parseInt(args[1]);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    Person person = allPeople.get(i);
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + sdf.format(person.getBirthDate()));
                } catch (NumberFormatException e) {

                }
                break;
        }
//        for (Person person : allPeople) System.out.println(person.getName() + " "
//                + (person.getSex() == Sex.MALE ? "м" : "ж") + " "
//                + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
    }
}
