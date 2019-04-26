package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import org.academiadecodigo.tropadelete.networking.ConnectionHandler;
import org.academiadecodigo.tropadelete.views.LoginView;
import org.academiadecodigo.tropadelete.views.MainView;

import java.util.HashSet;
import java.util.Set;

public class ChatClient extends ApplicationAdapter implements MessageHandler {

    private Set<Channel> channels;

    private MainView mainView;
    private LoginView loginView;
    private ConnectionHandler server;

    @Override
    public void create() {
        channels = new HashSet<>();
        mainView = new MainView();
        mainView.setChatClient(this);
        server = new ConnectionHandler(this);

        mainView.create();
        server.start();

    }

    @Override
    public void render() {
        mainView.render();

    }

    @Override
    public void handleIncomming(String message) {
        if (!message.startsWith("/")) {
            System.out.println("what:" +message);
            mainView.handleIncomming(message);
            return;
        }

        String[] split = message.split(" ");

        if (split[0].startsWith("/PRIVMSG") && split.length >=3) {
            mainView.handlePrivmsg(split[1], split[2]);

        } else if (split[0].startsWith("/CHANNEL_JOINED") && split.length >= 3) {
            mainView.handleJoinChannel(split[1]);

        }else{
            mainView.handleIncomming(message);
        }
    }




    public void sendToServer(String message) {
        server.sendMessageToServer(message);
    }

    @Override
    public void dispose() {
        mainView.dispose();
    }


}
