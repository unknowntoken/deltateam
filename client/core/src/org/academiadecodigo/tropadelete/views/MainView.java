package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import org.academiadecodigo.tropadelete.MessageHandler;
import org.academiadecodigo.tropadelete.networking.ConnectionHandler;


public class MainView extends ApplicationAdapter implements InputProcessor, MessageHandler {

    private Stage stage;
    private SpriteBatch batch;

    private ShapeRenderer border;
    private ShapeRenderer messageFieldBackground;

    private Texture background;
    private Texture chatBox;

    private Rectangle backgroundRec;
    private Rectangle chatBoxRec;

    private TextField inputMessage;
    private TextArea message_field;

    private ConnectionHandler server;

    public void setConnectionHandler (ConnectionHandler server){
        this.server = server;
    }


    public void incommingMessage (String message){

        message_field.appendText(message);

    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        stage = new Stage();

        background = new Texture("graphics/welcome_background-01_1920x1080.png");
        chatBox = new Texture("graphics/chatbox-01_1200x675.png");

        backgroundRec = new Rectangle();
        backgroundRec.x = 0;
        backgroundRec.y = 0;
        backgroundRec.width = 1920;
        backgroundRec.height = 1080;

        chatBoxRec = new Rectangle();
        chatBoxRec.x = 355;
        chatBoxRec.y = 200;
        chatBoxRec.width = 1200;
        chatBoxRec.height = 675;

        TextField.TextFieldStyle messageStyle = new TextField.TextFieldStyle();
        messageStyle.fontColor = Color.BLACK;
        messageStyle.font = new BitmapFont();

        TextField.TextFieldStyle inputStyle = new TextField.TextFieldStyle();
        inputStyle.fontColor = Color.BLACK;
        inputStyle.font = new BitmapFont();

        message_field = new TextArea("", messageStyle);
        message_field.setWidth(1100);
        message_field.setHeight(575);
        message_field.setPosition(405, 250);
        message_field.toFront();

        border = new ShapeRenderer();
        messageFieldBackground = new ShapeRenderer();

        inputMessage = new TextField("", inputStyle);
        inputMessage.setPosition(405, 250);
        inputMessage.setSize(1100, 15);

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
        createImages();

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

        batch.dispose();
        background.dispose();
        chatBox.dispose();
        stage.dispose();

    }

    @Override
    public void handleIncomming(String message) {
        message_field.appendText(message);

    }
    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.ENTER){
            server.sendMessageToServer(inputMessage.getText());
            message_field.appendText(inputMessage.getText());
            message_field.appendText("\n");
            inputMessage.setText("");

        }else {
            inputMessage.appendText(Input.Keys.toString(keycode));

        }
        return false;
    }

    private void createImages() {

        batch.begin();

        batch.draw(background, backgroundRec.x, backgroundRec.y);
        batch.draw(chatBox, chatBoxRec.x, chatBoxRec.y);

        batch.end();

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
