package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".resources.withdraw_en");
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
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
            int amount = 0;
            while (true) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                try {
                    amount = Integer.parseUnsignedInt(ConsoleHelper.readString());
                    if (!currencyManipulator.isAmountAvailable(amount)) {
                        ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                        continue;
                    }

                    Map<Integer, Integer> requestAmount = currencyManipulator.withdrawAmount(amount);
                    requestAmount.forEach((key, value) -> ConsoleHelper.writeMessage("\t" + key + " - " + value));
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currency));
                    break;

                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                } catch (NotEnoughMoneyException e) {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                }
            }
            continueWithdraw(currency);
        } catch (CancelOperationException e) {
            throw new CancelOperationException("from.withdraw");
        }
    }

    private void continueWithdraw(String currency) throws InterruptOperationException, CancelOperationException {
        oldCurrency = null;
        isRepeat = false;
        ConsoleHelper.writeMessage(res.getString("continue.withdraw"));
        ConsoleHelper.writeMessage(res.getString("command.yes"));
        ConsoleHelper.writeMessage(res.getString("command.no"));
        String answer = ConsoleHelper.readString();
        if (answer.equalsIgnoreCase("Y")) {
            ConsoleHelper.writeMessage(res.getString("continue.withdraw.in.current"));
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
