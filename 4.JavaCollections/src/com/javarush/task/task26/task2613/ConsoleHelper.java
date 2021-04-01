package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));;

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException, CancelOperationException {
        String readString = null;
        try {
            readString = bis.readLine();
            if (readString.equalsIgnoreCase(res.getString("command.EXIT")))
                throw new InterruptOperationException();
            if (readString.equalsIgnoreCase(res.getString("command.CANCEL")))
                throw new CancelOperationException();
        } catch (IOException e) {
        }
        return readString;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.exit"));
    }

    public static void printCancelMessage(String operation) {
        writeMessage(String.format(res.getString("the.cancel"), res.getString(operation)));
    }

    public static String askCurrencyCode() throws InterruptOperationException, CancelOperationException {
        String code;
        do {
            writeMessage(res.getString("choose.currency.code"));
            code = readString();
            if (code.matches("[a-zA-Y]{3}"))
                break;
            writeMessage(res.getString("invalid.data"));
        } while (true);
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException, CancelOperationException {
        String text;
        do {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            text = readString();
            if (text.matches("\\d+\\s+\\d+"))
                break;
            writeMessage(res.getString("invalid.data"));
        } while (true);
        return text.split("\\s+");

    }

    public static Operation askOperation() throws InterruptOperationException, CancelOperationException {
        try {
            while (true) {
                try {
                    writeMessage(res.getString("choose.operation"));
                    return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                } catch (IllegalArgumentException ignored) {
                    writeMessage(res.getString("invalid.code.operation"));
                    writeMessage("\t1 - " + res.getString("operation.INFO"));
                    writeMessage("\t2 - " + res.getString("operation.DEPOSIT"));
                    writeMessage("\t3 - " + res.getString("operation.WITHDRAW"));
//                    writeMessage("\t4 - " + res.getString("operation.EXIT"));
                }
            }
        } catch (CancelOperationException e) {
            ConsoleHelper.printCancelMessage("from.main");
        }
        return Operation.LOGIN;
    }
}
