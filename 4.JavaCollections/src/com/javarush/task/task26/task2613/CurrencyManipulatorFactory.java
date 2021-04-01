package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static final Map<String, CurrencyManipulator> map = new TreeMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        return map.computeIfAbsent(currencyCode.toUpperCase(), CurrencyManipulator::new);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
