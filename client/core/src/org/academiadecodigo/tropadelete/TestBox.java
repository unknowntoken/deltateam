package org.academiadecodigo.tropadelete;

import org.academiadecodigo.tropadelete.networking.ConnectionHandler;
import org.academiadecodigo.tropadelete.networking.MessageHandler;
import org.academiadecodigo.tropadelete.networking.MessageHandlerImpl;

import java.net.InetAddress;
import java.net.URL;

public class TestBox {

    private ConnectionHandler connectionHandler;

    public TestBox() {
        MessageHandler messageHandler = new MessageHandlerImpl();
        connectionHandler = new ConnectionHandler(messageHandler,"localhost");
        connectionHandler.start();

        connectionHandler.sendMessageToServer("HELLO");

    }

}
