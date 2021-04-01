package com.javarush.task.task30.task3008;

import com.sun.org.apache.bcel.internal.classfile.ConstantLong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    
    public static void sendBroadcastMessage(Message message) {
        connectionMap.forEach((key, value) -> {
            try {
                value.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение пользователю " + key);
            }
        });
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите номер порта.");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Thread handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String requestName = "Введите Ваше имя";
            StringBuilder request = new StringBuilder("");
            while (true) {
                request.append(requestName);
                connection.send(new Message(MessageType.NAME_REQUEST, request.toString()));
                Message ansName = connection.receive();
                if (ansName.getType() == MessageType.USER_NAME) {
                    String name = ansName.getData();
                    if (!name.equals("") ) {
                        if (!connectionMap.containsKey(name)) {
                            connectionMap.put(name, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя принято"));
                            return name;
                        }
                        request = new StringBuilder("Пользователь с таким именем существует. ");
                        continue;
                    }
                    request = new StringBuilder("Не допускается указывать пустое имя. ");
                    continue;
                }
                request = new StringBuilder("Получен не верный тип сообщения от клиента. ");
            }
        }

        private void  notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED,  name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Неверный тип сообщения.");
                } else {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket)) {
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }
            if (name != null) {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            }
            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом %s закрыто.", socket.getRemoteSocketAddress()));
        }
    }
}
