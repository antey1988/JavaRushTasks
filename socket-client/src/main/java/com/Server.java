package com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int port = 8989;
    private static int count = 2;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            while (count > 0) {
                System.out.println("Waiting client...");
                Socket client = server.accept();
                count--;
                System.out.printf("Client %s is connect\n\n", client.getRemoteSocketAddress());
                new Thread(new ServerProcess(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerProcess implements Runnable {
        private Socket socket;

        private ServerProcess(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(String.format("Hello from server: %s to client: %s\n",
                        socket.getLocalSocketAddress(), socket.getRemoteSocketAddress()));
                dataOutputStream.flush();
                while (true) {
                    System.out.printf("Waiting word from client\n", socket.getRemoteSocketAddress());
                    String line = dataInputStream.readUTF();
                    if (line.equalsIgnoreCase("exit")) {
                        break;
                    }
                    System.out.printf("Word from client %s\n", line);
                    line = new StringBuilder(line).reverse().toString();
                    System.out.printf("Reversed word is %s\n", line);
                    dataOutputStream.writeUTF(line);
                    dataOutputStream.flush();
                    System.out.printf("Word send to client %s\n\n", socket.getRemoteSocketAddress());
                }
                System.out.printf("Client disconnect");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
