package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer,Integer> denominations = new TreeMap<>(Comparator.reverseOrder());

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        Integer oldCount = denominations.computeIfAbsent(denomination, key->0);
        denominations.put(denomination, oldCount+count);
    }

    public int getTotalAmount() {
        return denominations.entrySet().stream().map(e->e.getKey()*e.getValue()).reduce(0, Integer::sum);
    }

    public boolean hasMoney() {
        return !denominations.isEmpty() && getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer,Integer> denominationsInRequest = new TreeMap<>(Comparator.reverseOrder());
        int amountInManipulator = getTotalAmount();
        int amountInRequest = expectedAmount;
        Iterator<Map.Entry<Integer, Integer>> iter = denominations.entrySet().iterator();
        while (amountInRequest <= amountInManipulator && iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            int currentDenomination = entry.getKey();
            int currentCountInManipulator = entry.getValue();
            if (amountInRequest >= currentDenomination) {
                int currentCountInRequest = amountInRequest / currentDenomination;
                denominationsInRequest.put(currentDenomination, currentCountInRequest);
                amountInRequest -= currentDenomination * currentCountInRequest;
            }
            amountInManipulator -= currentDenomination * currentCountInManipulator;
        }

        if (amountInRequest != 0)
            throw new NotEnoughMoneyException();

        denominationsInRequest.forEach((key1, value1)->denominations.computeIfPresent(key1,(key2, value2)->value2 - value1));
        return denominationsInRequest;
    }
}
