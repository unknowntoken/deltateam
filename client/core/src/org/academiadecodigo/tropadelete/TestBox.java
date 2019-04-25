package org.academiadecodigo.tropadelete;

import org.academiadecodigo.tropadelete.networking.ConnectionHandler;
import org.academiadecodigo.tropadelete.networking.MessageHandler;
import org.academiadecodigo.tropadelete.networking.MessageHandlerImpl;

import java.net.InetAddress;
import java.net.URL;

public class TestBox {

    public static void main(String[] args) {
        new TestBox();
    }

    public TestBox() {

        MessageHandler messageHandler = new MessageHandlerImpl();
        ConnectionHandler connectionHandler = new ConnectionHandler(messageHandler);
        connectionHandler.start();
        connectionHandler.sendMessageToServer("HELLO");

    }

}
