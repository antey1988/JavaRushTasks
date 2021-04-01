package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

import java.io.StringReader;
import java.io.StringWriter;

/* 
Service Locator
*/

public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

        StringReader sr = new StringReader("F,hf-rf,f,hf");
        StringWriter sw = new StringWriter();
    }

}
