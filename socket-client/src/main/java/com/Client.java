package com;

import java.io.*;
import java.net.Socket;

public class Client {
    private static String serverName = "localhost";
    private static int serverPort = 8989;

    public static void main(String[] args) {
        System.out.printf("Connection with server name: %s, port: %d\n", serverName, serverPort);
        try {
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket(serverName, serverPort);
            System.out.printf("Local socket information: %1$s, remote socket information: %2$s\n", socket.getLocalSocketAddress(), socket.getRemoteSocketAddress());
            /*BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = br.readLine();*/
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String line = dataInputStream.readUTF();
            System.out.println("First message from server: " + line);
            while (true) {
                System.out.println("Input word which reversed");
                line = keyboard.readLine();
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();
                System.out.printf("Word '%s'send to server\n", line);
                if (line.equalsIgnoreCase("exit")) break;
                line = dataInputStream.readUTF();
                System.out.printf("reverse word from server: %s\n\n", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
