package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".resources.exit_en");

    @Override
    public boolean repeatCommand() {
        return false;
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        try {
            String response = ConsoleHelper.readString();
            if (response.equalsIgnoreCase("y"))
                //            ConsoleHelper.sayGoodBue();
                ConsoleHelper.writeMessage(res.getString("thank.message"));
        } finally {
            throw new InterruptOperationException();
        }
    }
}
