package com.javarush.task.task20.task2003;

import sun.util.resources.cldr.or.CurrencyNames_or;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputStream fis = new FileInputStream(br.readLine());
        br.close();
        load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        final String RAZDEL = " : ";
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        Properties _properties = new Properties();
        _properties.putAll(properties);
        _properties.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties _properties = new Properties();
        _properties.load(inputStream);
        properties = new HashMap(_properties);
    }

    public static void main(String[] args) {

    }
}
