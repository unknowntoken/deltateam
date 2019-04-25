package org.academiadecodigo.tropadelete.networking;

import java.io.PrintWriter;
import java.util.Scanner;

public class MessageHandlerImpl implements MessageHandler {
    private Scanner userInput;
    private PrintWriter messageSender;

    @Override
    public void handleIncomming(String message) {

        System.out.println(message);



    }
}
