package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private int course;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    @Override
    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void incAverageGrade(double averageGrade) {
        setAverageGrade(getAverageGrade() + averageGrade);
    }

    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}