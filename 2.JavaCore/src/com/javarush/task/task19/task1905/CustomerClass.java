package com.javarush.task.task19.task1905;

public class CustomerClass implements Solution.Customer {
    String companyName = "JavaRush Ltd.";        //For example: JavaRush Ltd.
    String countryName = "Ukraine";        //For example: Ukraine


    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }
}
