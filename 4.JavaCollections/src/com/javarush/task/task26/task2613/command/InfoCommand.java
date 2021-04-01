package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".resources.info_en");

    @Override
    public boolean repeatCommand() {
        return false;
    }

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        final boolean[] hasMoney = {false};
        CurrencyManipulatorFactory.getAllCurrencyManipulators().stream().filter(CurrencyManipulator::hasMoney).forEach((m)->{
            ConsoleHelper.writeMessage(String.format("%s - %d", m.getCurrencyCode(), m.getTotalAmount()));
            hasMoney[0] = true;
        });
        if (!hasMoney[0]) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
