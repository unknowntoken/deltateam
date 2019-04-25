package org.academiadecodigo.tropadelete.commands;

public enum Commands {

<<<<<<< HEAD
    LOGIN("login", new LoginCommand()),
    BROADCAST("broadcast", new BroadcastCommand()),
    WHISPER("whisper", new WhisperCommand()),
    NICKNAME("nickname", new NicknameCommand());

    private String message;
    private CommandHandler handler;
    private final String COMMAND_IDENTIFIER = "/";

    Commands(String message, CommandHandler handler) {

        this.message = message;
        this.handler = handler;

    }

    public static Commands textCommand(String message){

        if(!message.startsWith()){

        }

    }


=======
    server.sendComand (boradcast, "message");
>>>>>>> 961af385099545aeb0991fef19fd23399c6d68e6
}



public void handleIncommingMessage (Type type, Message message){

    mainTextBox.addMessage (message);

}