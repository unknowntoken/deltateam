package org.academiadecodigo.tropadelete.views;

import org.academiadecodigo.tropadelete.ChatClient;

public interface View {
    void handleJoinChannel (String channel);
    void handlePrivmsg(String from, String message);
    void handleIncomming(String message);
    void setChatClient(ChatClient chatClient);
    void create ();
    void render ();
    void dispose ();

}
