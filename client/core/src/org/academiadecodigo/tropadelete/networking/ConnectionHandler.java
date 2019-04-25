package org.academiadecodigo.tropadelete.networking;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class ConnectionHandler {
    private Socket connectionToServer;
    public static final int SERVER_PORT = 9999;
    private MessageHandler messageHandler;
    private Scanner userInput;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;


    public ConnectionHandler(MessageHandler messageHandler, String url) {
        this.messageHandler = messageHandler;
        try {
            connectionToServer = new Socket(url, SERVER_PORT);
            bufferedReader = new BufferedReader(new InputStreamReader(connectionToServer.getInputStream()));
            printWriter = new PrintWriter((new OutputStreamWriter(connectionToServer.getOutputStream())));
        } catch (IOException e) {
            System.err.println("Error on creating a new Socket " + e.getMessage());
        }

    }

    public void start (){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listenToIncomming();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessageToServer(String message) {
        if (!connectionToServer.isClosed()) {
            printWriter.println(message);
        }

    }


    private void listenToIncomming() throws IOException {

        try {

            while (!connectionToServer.isClosed()) {

                String message = bufferedReader.readLine();

                if (message == null) {
                    break;
                }
                System.out.println(message);
                messageHandler.handleIncomming(message);

            }
        } catch (IOException e) {
            System.err.println("Error on Receiving message from other Clients: " + e.getMessage());
        } finally {
            close();
        }
    }

    private void close() {
        close(connectionToServer);
    }


    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
