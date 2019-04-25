package org.academiadecodigo.tropadelete.net;

import org.academiadecodigo.tropadelete.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientListener implements Runnable{

    private ServerSocket serverSocket;
    private long connectionNumber;

    public ClientListener (int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.connectionNumber =0;

    }

    public void run() {
        while (!serverSocket.isClosed()){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("new connection");
                new ClientHandler().handleNewClient(socket, String.valueOf(connectionNumber++));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
