package com.javarush.task.task19.task1903;

public class IncomeDataClass implements Solution.IncomeData {
    private String countryCode = "RU";        //For example: UA
    private String company = "JavaRush Ltd.";            //For example: JavaRush Ltd.
    private String contactFirstName = "Ivan";   //For example: Ivan
    private String contactLastName = "Ivanov";    //For example: Ivanov
    private int countryPhoneCode = 38;      //For example: 38
    private int phoneNumber = 501234567;           //For example: 501234567}

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String getCompany() {
        return company;
    }

    @Override
    public String getContactFirstName() {
        return contactFirstName;
    }

    @Override
    public String getContactLastName() {
        return contactLastName;
    }

    @Override
    public int getCountryPhoneCode() {
        return countryPhoneCode;
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }
}

