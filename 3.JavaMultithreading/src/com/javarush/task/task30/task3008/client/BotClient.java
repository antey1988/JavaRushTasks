package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName(String text) {
        return String.format("date_bot_%d", (int)(Math.random()*100));
    }

    public static void main(String[] args) {
        Client bot = new BotClient();
        bot.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] words = message.split(": ");
            if (words.length != 2) return;            
            String name = words[0];
            String text = words[1];

            String format = null;
            switch (text) {
                case "дата" : {
                    format = "d.MM.YYYY";
                    break;
                }
                case "день" : {
                    format = "d";
                    break;
                }
                case "месяц" : {
                    format = "MMMM";
                    break;
                }
                case "год" : {
                    format = "YYYY";
                    break;
                }
                case "время" : {
                    format = "H:mm:ss";
                    break;
                }
                case "час" : {
                    format = "H";
                    break;
                }
                case "минуты" : {
                    format = "m";
                    break;
                }
                case "секунды" : {
                    format = "s";
                    break;
                }
            }
            if (format != null) {
                Date date = Calendar.getInstance().getTime();
                sendTextMessage(String.format("Информация для %s: %s", name, new SimpleDateFormat(format).format(date)));
            }
        }
    }
}
