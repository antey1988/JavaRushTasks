package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> t;

    public Generator(Class<T> t) {
        this.t = t;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T) t.newInstance();
    }
}
