package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".resources.login_en");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".resources.verifiedCards");

    @Override
    public boolean repeatCommand() {
        return false;
    }

    @Override
    public void execute() throws InterruptOperationException {
        /*while (true) {
            ConsoleHelper.writeMessage("Enter number and pincode card in format '12-digit 4-digit'");
            String numberAndPincode = ConsoleHelper.readString();
            if (!numberAndPincode.matches("\\d{12}\\s+\\d{4}")) {
                ConsoleHelper.writeMessage("Not valid values");
            } else {
                String[] card = numberAndPincode.split("\\s+");
                if (validCreditCards.containsKey(card[0]) && validCreditCards.getString(card[0]).equals(card[1])) {
                    ConsoleHelper.writeMessage("Hello!");
                    break;
                }
                ConsoleHelper.writeMessage("Not correct number or pincode card");
            }
        }*/
        while (true) {
            try {
                ConsoleHelper.writeMessage(res.getString("before"));
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                String creditCardNumber = ConsoleHelper.readString();
                String pinStr = ConsoleHelper.readString();
                if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
                        pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                } else {
                    try {
                        if (validCreditCards.containsKey(creditCardNumber) && pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                            break;
                        } else {
                            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                        }
                    } catch (NumberFormatException e) {
                        ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    }
                }
            } catch (CancelOperationException e) {
                ConsoleHelper.printCancelMessage("from.login");
            }
        }
    }
}
