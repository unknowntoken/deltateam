package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import org.academiadecodigo.tropadelete.networking.ConnectionHandler;
import org.academiadecodigo.tropadelete.views.*;

import java.util.HashSet;
import java.util.Set;

public class ChatClient extends ApplicationAdapter implements MessageHandler {

    private Set<Channel> channels;

    private View view;
    private ConnectionHandler server;


    @Override
    public void create() {
        channels = new HashSet<>();
        view = new MainView();
        view.setChatClient(this);
        server = new ConnectionHandler(this);

        view.create();
        server.start();
    }


    @Override
    public void render() {
        view.render();

    }

    @Override
    public void handleIncomming(String message) {
        if (!message.startsWith("/")) {
            System.out.println("what:" + message);
            view.handleIncomming(message);
            return;
        }

        String[] split = message.split(" ");

        if (split[0].startsWith("/PRIVMSG") && split.length >= 3) {
            view.handlePrivmsg(split[1], split[2]);

        } else if (split[0].startsWith("/CHANNEL_JOINED") && split.length >= 3) {
            view.handleJoinChannel(split[1]);

        } else {
            view.handleIncomming(message);
        }
    }

    public synchronized void changeToWelcomeView (){
        changeView((View) new WelcomeView());
    }
    public synchronized void changeToLoginView() {
        changeView((View) new LoginView());

    }

    public synchronized void changeToRegisterView() {
        changeView((View) new RegisterView());
    }

    public synchronized void changeToMainView() {
        changeView((View) new MainView());
    }

    private void changeView(View newView) {
        view.dispose();
        view = newView;
        view.setChatClient(this);
        view.create();
    }


    public void sendToServer(String message) {
        server.sendMessageToServer(message);
    }

    @Override
    public void dispose() {
        view.dispose();
    }


}
