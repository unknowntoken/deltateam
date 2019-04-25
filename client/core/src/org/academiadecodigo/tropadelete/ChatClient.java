package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import org.academiadecodigo.tropadelete.networking.ConnectionHandler;
import org.academiadecodigo.tropadelete.views.LoginView;
import org.academiadecodigo.tropadelete.views.MainView;

public class ChatClient extends ApplicationAdapter implements InputProcessor {

    private LoginView login;
    private LoginView view;
    private ConnectionHandler server;

    @Override
    public void create() {
        view = new LoginView();

        //server = new ConnectionHandler(new MainView());
        //view.setConnectionHandler(server);
        view.create();
        //server.start();

    }

    @Override
    public void render() {
        view.render();

    }

    @Override
    public void dispose() {
        view.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
