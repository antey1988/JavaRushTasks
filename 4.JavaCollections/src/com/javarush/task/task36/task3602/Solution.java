package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws IllegalAccessException, InstantiationException {
        Class<Collections> clazz = Collections.class;
        for (Class<?> cl : clazz.getDeclaredClasses()) {
            if (cl.getModifiers() == (Modifier.STATIC | Modifier.PRIVATE)) {
                if (List.class.isAssignableFrom(cl)) {
//                    System.out.println(cl);
                    Constructor<?> constructor = null;
                    for (Constructor<?> con : cl.getDeclaredConstructors()) {
//                        System.out.println("   " + con + " : ");
                        if (con.getParameterCount() == 0) {
                            constructor = con;
                            break;
                        }
                    }
                    if (constructor != null) {
                        try {
                            Method met = cl.getDeclaredMethod("get", int.class);
                            met.setAccessible(true);
                            constructor.setAccessible(true);
                            met.invoke(constructor.newInstance(), 0);
                        } catch (InvocationTargetException | NoSuchMethodException e) {
                            return cl;
                        }
                    }
                }
            }
        }
        return null;
    }

    /*private static boolean isImplInterface(Class<?> clazz, Class<?> inter) {
        boolean isImplInt = false;

        return isImplInt;
    }*/
}
