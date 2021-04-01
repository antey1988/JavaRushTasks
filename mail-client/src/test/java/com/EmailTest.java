package com;

import java.io.*;
import java.lang.reflect.Proxy;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class EmailTest {
//    private final static String PROPS_FILE = EmailTest.class.getResource("/Mail.properties").getFile();

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress);
            Arrays.stream(InetAddress.getAllByName("localhost")).forEach(System.out::println);
            Arrays.stream(Inet6Address.getAllByName("yandex.ru")).forEach(System.out::println);
            Arrays.stream(Inet6Address.getAllByName("mail.ru")).forEach(System.out::println);
            Arrays.stream(Inet6Address.getAllByName("google.com")).forEach(System.out::println);
        } catch (UnknownHostException e ) {
            e.printStackTrace();
        }
        /*URL url = EmailTest.class.getResource("/Mail.properties");
        String PROPS_FILE = EmailTest.class.getResource("/Mail.properties").getFile();
        try {
            InputStream is = new FileInputStream(PROPS_FILE);
            if (is != null) {
                Properties properties = new Properties();
                properties.load(is);
                EmailMessage.SMTP_SERVER = properties.getProperty("mail.server");
                EmailMessage.SMTP_PORT = properties.getProperty("mail.port");
                EmailMessage.SMTP_AUTH_USER = properties.getProperty("mail.user");
                EmailMessage.SMTP_AUTH_PASS = properties.getProperty("mail.password");
                EmailMessage.EMAIL_FROM = properties.getProperty("mail.user");
//                EmailMessage.REPLY_TO = properties.getProperty("mail.reply");
//                EmailMessage.FILE_PATH = PROPS_FILE;
                String mailTo = properties.getProperty("mail.to");
                String thema = properties.getProperty("mail.thema");
                String text = properties.getProperty("mail.text");

                EmailMessage emailMessage = new EmailMessage(mailTo, thema);
                if (emailMessage.sendMessage(text)) System.out.println("Сообщение отправлено");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
