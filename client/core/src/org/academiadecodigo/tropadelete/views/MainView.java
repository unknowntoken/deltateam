package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

import java.awt.*;

public class MainView extends ApplicationAdapter implements InputProcessor {

    private Stage stage;

    private ShapeRenderer border;
    private ShapeRenderer messageFieldBackground;

    private Texture background;
    private Texture chatBox;

    private Rectangle backgroundRec;
    private Rectangle chatBoxRec;

    private TextField inputMessage;
    private TextArea message_field;

    //private MessageHandler messageHandler;

    public void incommingMessage (String message){

        message_field.appendText(message);

    }

    @Override
    public void create() {

        stage = new Stage();

        background = new Texture("graphics/welcome_background-01_1920x1080.png");
        chatBox = new Texture("graphics/chatbox-01_1200x675.png");

        backgroundRec = new Rectangle();
        backgroundRec.x = 0;
        backgroundRec.y = 0;
        backgroundRec.width = 1920;
        backgroundRec.height = 1080;

        chatBoxRec = new Rectangle();
        chatBoxRec.x = 0;
        chatBoxRec.y = 0;
        chatBoxRec.width = 1200;
        chatBoxRec.height = 675;

        TextField.TextFieldStyle messageStyle = new TextField.TextFieldStyle();
        messageStyle.fontColor = Color.BLACK;
        messageStyle.font = new BitmapFont();

        TextField.TextFieldStyle inputStyle = new TextField.TextFieldStyle();
        inputStyle.fontColor = Color.BLACK;
        inputStyle.font = new BitmapFont();

        message_field = new TextArea("", messageStyle);
        message_field.setWidth(555);
        message_field.setHeight(400);
        message_field.setX(20);
        message_field.setY(100);
        message_field.toFront();

        border = new ShapeRenderer();
        messageFieldBackground = new ShapeRenderer();

        inputMessage = new TextField("", inputStyle);
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

        borderAndBackground(message_field);
        borderAndBackground(inputMessage);

        stage.draw();
        stage.act();
    }

    private void borderAndBackground(Widget element) {

        border.begin(ShapeRenderer.ShapeType.Filled);
        border.setColor(Color.BLACK);
        border.rect(element.getX()-5,element.getY()-5,element.getWidth()+10,element.getHeight()+10);
        border.end();

        border.begin(ShapeRenderer.ShapeType.Filled);
        border.setColor(Color.WHITE);
        border.rect(element.getX(),element.getY(),element.getWidth(),element.getHeight());
        border.end();

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
