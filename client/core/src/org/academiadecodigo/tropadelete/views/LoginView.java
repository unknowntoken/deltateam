package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import org.academiadecodigo.tropadelete.ChatClient;


public class LoginView extends ApplicationAdapter implements InputProcessor, View {

    private Stage stage;
    private SpriteBatch batch;

    private Texture loginImage;
    private Texture background;

    private Rectangle backgroundRect;
    private Rectangle loginImageRect;

    private TextField username;
    private TextField password;

    private Rectangle loginPanel;

    private Rectangle loginButton;
    private ChatClient chatClient;
    private int count;

    @Override
    public void create() {

        stage = new Stage();
        batch = new SpriteBatch();

        background = new Texture("graphics/welcome_background-01_1920x1080.png");
        loginImage = new Texture("graphics/login_view-01.png");


        backgroundRect = new Rectangle();
        backgroundRect.x = 0;
        backgroundRect.y = 0;
        backgroundRect.width = 1920;
        backgroundRect.height = 1080;

        loginImageRect = new Rectangle();

        loginImageRect.x = 660;
        loginImageRect.y = 390;
        loginImageRect.width = 600;
        loginImageRect.height = 300;

        loginButton = new Rectangle();
        loginButton.x = loginImageRect.x;
        loginButton.y = loginImageRect.y;
        loginButton.width = loginImageRect.width;
        loginButton.height = loginImageRect.height;

        username = textFieldAndStyle();
        username.setPosition(100, 100);

        password = textFieldAndStyle();
        password.setPosition(100, 150);

        loginPanel = new Rectangle();

        stage.addActor(username);
        stage.addActor(password);

        Gdx.input.setInputProcessor(this);

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

        renderLoginImages();

        stage.draw();
        stage.act();
        chatClient.changeToMainView();
    }

    @Override
    public void dispose() {

        stage.dispose();

    }

    @Override
    public void handleBadAuth() {

    }

    @Override
    public void handleNameAlreadyInUse() {

    }

    private void renderLoginImages() {

        batch.begin();

        batch.draw(background, backgroundRect.x, backgroundRect.y);
        batch.draw(loginImage, loginImageRect.x, loginImageRect.y);

        batch.end();

    }

    @Override
    public void handlePrivmsg(String from, String message) {

    }

    @Override
    public void handleIncomming(String message) {

    }

    @Override
    public void setChatClient(ChatClient chatClient) {
        this.chatClient = chatClient;
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
        if (loginButton.contains(screenX, screenY)) {
            System.out.println("COLLISION!!!!");
            return false;
        }
        System.out.println("NO collision");
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

    @Override
    public void handleJoinChannel(String channel) {

    }


}

