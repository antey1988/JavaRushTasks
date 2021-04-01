package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {
        String PROPS_FILE = SendMail.class.getResource("/Mail.properties").getFile();
        try {
            InputStream is = new FileInputStream(PROPS_FILE);
            if (is != null) {
                Properties properties = new Properties();
                properties.load(is);

                EmailMessage.SMTP_SERVER = properties.getProperty("mail.server");
                EmailMessage.SMTP_PORT = properties.getProperty("mail.port");
                EmailMessage.SMTP_AUTH_USER = properties.getProperty("mail.user");
                EmailMessage.SMTP_AUTH_PASS = properties.getProperty("mail.password");
                EmailMessage.EMAIL_FROM = properties.getProperty("mail.from");
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
        }
    }
}
