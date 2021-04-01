package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName();
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation = Operation.LOGIN;
        try {
            while (true) {
                try {
                    CommandExecutor.execute(operation);
                    operation = ConsoleHelper.askOperation();
                } catch (CancelOperationException e) {
                    ConsoleHelper.printCancelMessage(e.getMessage());
                    operation = Operation.LOGIN;
                }
            }
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }
}
