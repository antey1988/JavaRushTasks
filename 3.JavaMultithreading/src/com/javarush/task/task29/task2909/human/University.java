package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {
    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return students.stream().filter(s->s.getAverageGrade() == averageGrade).findFirst().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return students.stream().max(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        return students.stream().min(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public static void main(String[] args) {
        University university = new University("SFU", 150);
        List<Student> students = university.getStudents();
        students.add(new Student("Oleg", 18, 4.2));
        students.add(new Student("Olga", 18, 4.2));
        students.add(new Student("Ludmila", 18, 4.3));
        students.add(new Student("Alexander", 18, 4.1));
        System.out.println(university.getStudentWithAverageGrade(4.1).getName());
        System.out.println(university.getStudentWithMaxAverageGrade().getName());
        System.out.println(university.getStudentWithMinAverageGrade().getName());
    }
}