package com.javarush.task.task38.task3804;

public class FactoryThrowable {
    public static <T> Throwable get(T e) {
        Throwable t = new IllegalArgumentException();;
        if (e != null) {
            String string = String.valueOf(e).toLowerCase();
            string = string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase());
            string = string.replaceAll("_", " ");
            if (ApplicationExceptionMessage.class.equals(e.getClass())) {
                t = new Exception(string);
            } else if (DatabaseExceptionMessage.class.equals(e.getClass())) {
                t = new RuntimeException(string);
            } else if (UserExceptionMessage.class.equals(e.getClass())) {
                t = new Error(string);
            }
        }
        return t;
    }
}
