package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.CancelOperationException;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException, CancelOperationException;
    boolean repeatCommand();
}
