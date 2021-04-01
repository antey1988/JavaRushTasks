package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".resources.deposit_en");
    private boolean isRepeat;
    private String oldCurrency;

    @Override
    public boolean repeatCommand() {
        return isRepeat;
    }

    @Override
    public void execute() throws InterruptOperationException, CancelOperationException {
        if (!isRepeat) ConsoleHelper.writeMessage(res.getString("before"));
        try {
            String currency = oldCurrency;
            if (currency == null) {
                currency = ConsoleHelper.askCurrencyCode();
            }
            String[] valid = ConsoleHelper.getValidTwoDigits(currency);
            int denomination = Integer.parseInt(valid[0]);
            int count = Integer.parseInt(valid[1]);
            CurrencyManipulator firstManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
            firstManipulator.addAmount(denomination, count);
            ConsoleHelper.writeMessage(String.format((res.getString("success.format")), denomination * count, currency));
            continueDeposit(currency);
        } catch (CancelOperationException e) {
            throw new CancelOperationException("from.deposit");
        }
    }

    private void continueDeposit(String currency) throws InterruptOperationException, CancelOperationException {
        oldCurrency = null;
        isRepeat = false;
        ConsoleHelper.writeMessage(res.getString("continue.deposit"));
        ConsoleHelper.writeMessage(res.getString("command.yes"));
        ConsoleHelper.writeMessage(res.getString("command.no"));
        String answer = ConsoleHelper.readString();
        if (answer.equalsIgnoreCase("Y")) {
            ConsoleHelper.writeMessage(res.getString("continue.deposit.in.current"));
            ConsoleHelper.writeMessage(res.getString("command.yes"));
            ConsoleHelper.writeMessage(res.getString("command.no"));
            answer = ConsoleHelper.readString();
            if (answer.equalsIgnoreCase("Y")) {
                oldCurrency = currency;
            }
            isRepeat = true;
        }
    }
}
