package org.academiadecodigo.tropadelete.commands;

public enum Commands {

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


}
