package org.academiadecodigo.tropadelete;

import org.academiadecodigo.tropadelete.net.ClientListener;

import java.io.IOException;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        ClientListener listener = new ClientListener(9999);
        new Thread (listener).start();
    }
}
