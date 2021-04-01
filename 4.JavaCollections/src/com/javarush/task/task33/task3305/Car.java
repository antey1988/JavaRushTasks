package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
@JsonSubTypes(@JsonSubTypes.Type(value = Car.class, name = "com.javarush.task.task33.task3305.Car"))*/
public class Car extends Vehicle {
}