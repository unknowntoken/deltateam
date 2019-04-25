package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.awt.*;

public class MainView extends ApplicationAdapter implements InputProcessor {

    private Stage stage;

    private ShapeRenderer border;

    private TextField inputMessage;
    private TextArea message_field;

    //private MessageHandler messageHandler;

    public void incommingMessage (String message){

        message_field.appendText(message);

    }

    @Override
    public void create() {
        stage = new Stage();


        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.fontColor = Color.BLACK;
        style.font = new BitmapFont();

        message_field = new TextArea("", style);
        message_field.setWidth(585);
        message_field.setHeight(400);
        message_field.setX(10);
        message_field.setY(100);

        border = new ShapeRenderer();
        border.begin(ShapeRenderer.ShapeType.Filled);
        border.setColor(Color.BLACK);
        border.rect(message_field.getX()-1,message_field.getY()-1,message_field.getWidth()+1,message_field.getHeight()+1);
        border.end();


        inputMessage = new TextField("", style);
        inputMessage.setPosition(5, 20);
        inputMessage.setSize(585, 15);

        stage.addActor(inputMessage);
        stage.addActor(message_field);

        Gdx.input.setInputProcessor(this);

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

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.ENTER){
            message_field.appendText("\n");

        }else {
            inputMessage.appendText(Input.Keys.toString(keycode));
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
