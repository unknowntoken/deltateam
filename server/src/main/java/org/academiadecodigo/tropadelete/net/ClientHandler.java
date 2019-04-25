package org.academiadecodigo.tropadelete.net;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    private String username;

    public void handleNewClient(Socket socket, String username) throws IOException {
        System.out.println("handling new connection");
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        new Thread(this).start();
        this.username = username;
    }


    public void run() {
        String message;
        try {
            while (!socket.isClosed()) {
                message = bufferedReader.readLine();
                if (message == null) {
                    break;
                }

                System.out.println(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
