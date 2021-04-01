package com.javarush.task.task35.task3501;

import java.util.Map;

public class GenericStatic {
    public static <T> T someStaticMethod(T genericObject) {
        System.out.println(genericObject);
        return genericObject;
//        Map<String, String>
    }
}
