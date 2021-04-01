package com.javarush.task.task26.task2613.exception;

public class CancelOperationException extends Exception{
    public CancelOperationException(String s) {
        super(s);
    }

    public CancelOperationException(){}
}
