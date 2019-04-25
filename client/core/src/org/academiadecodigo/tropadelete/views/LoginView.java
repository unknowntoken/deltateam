package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

import java.awt.*;

public class LoginView extends ApplicationAdapter {

    private Stage stage;

    private TextField username;
    private TextField password;

    private Rectangle loginPanel;

    @Override
    public void create() {

        stage = new Stage();

        username = textFieldAndStyle();
        username.setPosition(100,100);

        password = textFieldAndStyle();
        password.setPosition(100,150);

        loginPanel = new Rectangle();

        stage.addActor(username);
        stage.addActor(password);

    }

    private TextField textFieldAndStyle() {

        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.fontColor = Color.BLACK;
        style.font = new BitmapFont();

        return new TextField("", style);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();
    }

    @Override
    public void dispose() {

        stage.dispose();

    }
}
