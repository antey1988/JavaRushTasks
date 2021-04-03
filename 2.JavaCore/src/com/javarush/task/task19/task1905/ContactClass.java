package com.javarush.task.task19.task1905;

public class ContactClass implements Solution.Contact {
    String name = "Ivanov, Ivan";               //For example: Ivanov, Ivan
    String phoneNumber = "+38(050)123-45-67";                    //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
