package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class MainView extends ApplicationAdapter implements InputProcessor {
    Stage stage;
    TextField textField;
    private TextArea message_field;

    @Override
    public void create() {
        stage = new Stage();

        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.fontColor = Color.BLACK;
        style.font = new BitmapFont();

        message_field = new TextArea("iausgdi", style);
        message_field.setWidth(400);
        message_field.setHeight(400);
        message_field.setX(0);
        message_field.setY(20);



        textField = new TextField("ad", style);
        textField.setPosition(70, 73);
        textField.setSize(300, 14);

        stage.addActor(textField);
        stage.addActor(message_field);

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.ENTER){
            message_field.appendText("\n");
        }else {
            textField.appendText(Input.Keys.toString(keycode));
            message_field.appendText(Input.Keys.toString(keycode));
        }
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
