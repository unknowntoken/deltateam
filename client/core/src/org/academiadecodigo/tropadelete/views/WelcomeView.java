package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class WelcomeView extends ApplicationAdapter implements InputProcessor {

    private Stage stage;
    private SpriteBatch batch;

    private Texture background;
    private Texture welcomeImage;

    private Rectangle backgroundRect;
    private Rectangle welcomeImageRect;

    private Rectangle registerButton;
    private Rectangle loginButton;

    @Override
    public void create() {

        stage = new Stage();
        batch = new SpriteBatch();

        background = new Texture("graphics/welcome_background-01_1920x1080.png");
        welcomeImage = new Texture("graphics/welcome_view-01.png");

        backgroundRect = new Rectangle();
        backgroundRect.x = 0;
        backgroundRect.y = 0;
        backgroundRect.width = 1920;
        backgroundRect.height = 1080;

        welcomeImageRect = new Rectangle();
        welcomeImageRect.x = 660;
        welcomeImageRect.y = 390;
        welcomeImageRect.width = 600;
        welcomeImageRect.height = 300;

        registerButton = new Rectangle();
        registerButton.x = 802;
        registerButton.y = 545;
        registerButton.width = 150;
        registerButton.height = 50;

        loginButton = new Rectangle();
        loginButton.x = 967;
        loginButton.y = 545;
        loginButton.width = 150;
        loginButton.height = 50;

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {

        renderWelcomeImages();

        stage.draw();
        stage.act();

    }

    @Override
    public void dispose() {

        batch.dispose();
        background.dispose();
        welcomeImage.dispose();
        stage.dispose();

    }

    private void renderWelcomeImages() {

        batch.begin();

        batch.draw(background, backgroundRect.x, backgroundRect.y);
        batch.draw(welcomeImage, welcomeImageRect.x, welcomeImageRect.y);

        batch.end();

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

        if (registerButton.contains(screenX, screenY)) {
            System.out.println("REGISTER COLLISION!!");
            return false;

        }

        if (loginButton.contains(screenX, screenY)) {
            System.out.println("LOGIN COLLISION");
            return false;
        }

        System.out.println("NOOO COLLISION!!");
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
