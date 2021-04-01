package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static Class getFactoryClass() {
        return FactoryThrowable.class;
    }

    public static void main(String[] args) {
        /*try {
            Method method = getFactoryClass().getMethod("get", new Class[]{Object.class});
            throw (Throwable)method.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }*/
    }
}