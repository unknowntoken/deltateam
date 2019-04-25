package org.academiadecodigo.tropadelete;

import java.net.Socket;

public class Client{
        private String username;
        private Socket socket;

        public Client (Socket socket, String username){
            this.socket = socket;
            this.username = username;
        }
}
