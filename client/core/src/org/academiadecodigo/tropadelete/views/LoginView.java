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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import org.academiadecodigo.tropadelete.ChatClient;

import static com.badlogic.gdx.Input.Keys.*;


public class LoginView extends ApplicationAdapter implements InputProcessor, View {

    /**
     * Left arrow key. If numpadDirections is enabled, this will also be sent by Numpad 4.
     */
    public static final char LEFT_ARROW = '\u2190';
    /**
     * Up arrow key. If numpadDirections is enabled, this will also be sent by Numpad 8.
     */
    public static final char UP_ARROW = '\u2191';
    /**
     * Down arrow key. If numpadDirections is enabled, this will also be sent by Numpad 6.
     */
    public static final char RIGHT_ARROW = '\u2192';
    /**
     * Down arrow key. If numpadDirections is enabled, this will also be sent by Numpad 2.
     */
    public static final char DOWN_ARROW = '\u2193';
    /**
     * Not typically a dedicated key, but if numpadDirections is enabled, this will be sent by Numpad 5.
     */
    public static final char CENTER_ARROW = '\u21BA';
    /**
     * Tab key. Used for entering horizontal spacing, such as indentation, but also often to cycle between menu items.
     */
    public static final char TAB = '\u21B9';
    /**
     * Delete key on most PC keyboards; no equivalent on some (all?) Mac keyboards. Used to delete the next character.
     * <p>
     * Not present on some laptop keyboards and some (all?) Mac keyboards.
     */
    public static final char FORWARD_DELETE = '\u2281';
    /**
     * Insert key. Not recommended for common use because it could affect other application behavior.
     * <p>
     * Not present on some laptop keyboards.
     */
    public static final char INSERT = '\u2208';
    /**
     * Page Down key.
     * <p>
     * Not present on some laptop keyboards.
     */
    public static final char PAGE_DOWN = '\u22A4';
    /**
     * Page Up key.
     * <p>
     * Not present on some laptop keyboards.
     */
    public static final char PAGE_UP = '\u22A5';
    /**
     * Home key (commonly used for moving a cursor to start of line).
     * <p>
     * Not present on some laptop keyboards.
     */
    public static final char HOME = '\u2302';
    /**
     * End key (commonly used for moving a cursor to end of line).
     * <p>
     * Not present on some laptop keyboards.
     */
    public static final char END = '\u2623';
    /**
     * Esc or Escape key
     */
    public static final char ESCAPE = '\u2620';
    private Stage stage;
    private SpriteBatch batch;
    private Texture loginImage;
    private Texture background;
    private Rectangle backgroundRect;
    private Rectangle loginImageRect;
    private TextField usernameField;
    private TextField passwordField;
    private Rectangle usernameRec;
    private Rectangle passwordRec;
    private ChatClient chatClient;
    private Rectangle exitRec;
    private Texture exitTex;
    private Rectangle loginRec;
    private Texture loginTex;
    private boolean usernameFocus = true;

    @Override
    public void create() {

        stage = new Stage();
        batch = new SpriteBatch();

        background = new Texture("graphics/welcome_background-01_1920x1080.png");
        loginImage = new Texture("graphics/noButtonsViews/login_view_no_buttons-01.png");
        exitTex = new Texture("graphics/buttons/register_close_button.png");
        loginTex = new Texture("graphics/buttons/welcome_login_button-03.png");

        loginRec = new Rectangle();
        loginRec.x = 680;
        loginRec.y = 620;
        loginRec.setHeight(loginTex.getHeight());
        loginRec.setWidth(loginTex.getWidth());

        exitRec = new Rectangle();
        exitRec.x = 1180;
        exitRec.y = 390;
        exitRec.height = 80;
        exitRec.width = 60;


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


        usernameField = textFieldAndStyle();
        usernameField.setPosition(100, 100);
        usernameField.setPosition(800, 566);
        usernameRec = new Rectangle();
        usernameRec.set(700, 482, 560, 40);


        passwordField = textFieldAndStyle();
        passwordField.setPosition(800, 498);
        passwordRec = new Rectangle();
        passwordRec.set(700, 548, 560, 50);

        stage.addActor(usernameField);
        stage.addActor(passwordField);

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
    }

    @Override
    public void dispose() {

        stage.dispose();

    }

    private void renderLoginImages() {

        batch.begin();

        batch.draw(background, backgroundRect.x, backgroundRect.y);
        batch.draw(loginImage, loginImageRect.x, loginImageRect.y);
        batch.draw(loginTex, loginRec.getX(), loginRec.getY() - 210);
        batch.draw(exitTex, exitRec.x, exitRec.y + 220);

        batch.end();

    }

    @Override
    public void handleBadAuth() {

    }

    @Override
    public void handleNameAlreadyInUse() {

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
        boolean alt = Gdx.input.isKeyPressed(ALT_LEFT) || Gdx.input.isKeyPressed(ALT_RIGHT),
                ctrl = Gdx.input.isKeyPressed(CONTROL_LEFT) || Gdx.input.isKeyPressed(CONTROL_RIGHT),
                shift = Gdx.input.isKeyPressed(SHIFT_LEFT) || Gdx.input.isKeyPressed(SHIFT_RIGHT);

        TextField field;
        if (usernameFocus) {
            field = usernameField;
        } else {
            field = passwordField;
        }

        if (keycode == BACKSPACE) {
            if (field.getText().length() != 0) {
                field.setText(field.getText().substring(0, field.getText().length() - 1));
            }
            return false;
        }
        char c = fromCode(keycode, shift);

        if (keycode == ENTER) {
            chatClient.sendToServer(field.getText());
            //field.setText("");
            return false;
        }
        if (usernameFocus) {
            field.appendText(String.valueOf(c));
        }else{
            field.appendText("*");
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
        if (loginRec.contains(screenX, screenY)) {
            System.out.println("Login collision!!!!");
            chatClient.changeToMainView();
            return false;
        }

        if (exitRec.contains(screenX, screenY)) {
            chatClient.changeToWelcomeView();
            System.out.println("exit collsion");
            return false;
        }

        if (usernameRec.contains(screenX, screenY)) {
            System.out.println("Username collision");
            usernameFocus = true;
            return false;
        }

        if (passwordRec.contains(screenX, screenY)) {
            System.out.println("Password collision");
            usernameFocus = false;
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
        System.out.println("X:" + screenX + ", Y:" + screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void handleJoinChannel(String channel) {

    }

    public char fromCode(int keycode, boolean shift) {
        switch (keycode) {
            case Input.Keys.HOME:
                return HOME;
            case Input.Keys.FORWARD_DEL:
                return FORWARD_DELETE;
            case Input.Keys.ESCAPE:
                return ESCAPE;
            case Input.Keys.END:
                return END;

            case Input.Keys.UP:
                return UP_ARROW;
            case Input.Keys.DOWN:
                return DOWN_ARROW;
            case Input.Keys.LEFT:
                return LEFT_ARROW;
            case Input.Keys.RIGHT:
                return RIGHT_ARROW;
            case Input.Keys.CENTER:
                return CENTER_ARROW;

            case Input.Keys.NUM_0:
                return (shift) ? '=' : '0';
            case Input.Keys.NUM_1:
                return (shift) ? '!' : '1';
            case Input.Keys.NUM_2:
                return (shift) ? '"' : '2';
            case Input.Keys.NUM_3:
                return (shift) ? '#' : '3';
            case Input.Keys.NUM_4:
                return (shift) ? '$' : '4';
            case Input.Keys.NUM_5:
                return (shift) ? '%' : '5';
            case Input.Keys.NUM_6:
                return (shift) ? '&' : '6';
            case Input.Keys.NUM_7:
                return (shift) ? '/' : '7';
            case Input.Keys.NUM_8:
                return (shift) ? '(' : '8';
            case Input.Keys.NUM_9:
                return (shift) ? ')' : '9';
            case Input.Keys.COLON:
                return ':';
            case Input.Keys.STAR:
                return '*';
            case Input.Keys.POUND:
                return '#';
            case Input.Keys.A:
                return (shift) ? 'A' : 'a';
            case Input.Keys.B:
                return (shift) ? 'B' : 'b';
            case Input.Keys.C:
                return (shift) ? 'C' : 'c';
            case Input.Keys.D:
                return (shift) ? 'D' : 'd';
            case Input.Keys.E:
                return (shift) ? 'E' : 'e';
            case Input.Keys.F:
                return (shift) ? 'F' : 'f';
            case Input.Keys.G:
                return (shift) ? 'G' : 'g';
            case Input.Keys.H:
                return (shift) ? 'H' : 'h';
            case Input.Keys.I:
                return (shift) ? 'I' : 'i';
            case Input.Keys.J:
                return (shift) ? 'J' : 'j';
            case Input.Keys.K:
                return (shift) ? 'K' : 'k';
            case Input.Keys.L:
                return (shift) ? 'L' : 'l';
            case Input.Keys.M:
                return (shift) ? 'M' : 'm';
            case Input.Keys.N:
                return (shift) ? 'N' : 'n';
            case Input.Keys.O:
                return (shift) ? 'O' : 'o';
            case Input.Keys.P:
                return (shift) ? 'P' : 'p';
            case Input.Keys.Q:
                return (shift) ? 'Q' : 'q';
            case Input.Keys.R:
                return (shift) ? 'R' : 'r';
            case Input.Keys.S:
                return (shift) ? 'S' : 's';
            case Input.Keys.T:
                return (shift) ? 'T' : 't';
            case Input.Keys.U:
                return (shift) ? 'U' : 'u';
            case Input.Keys.V:
                return (shift) ? 'V' : 'v';
            case Input.Keys.W:
                return (shift) ? 'W' : 'w';
            case Input.Keys.X:
                return (shift) ? 'X' : 'x';
            case Input.Keys.Y:
                return (shift) ? 'Y' : 'y';
            case Input.Keys.Z:
                return (shift) ? 'Z' : 'z';
            case Input.Keys.COMMA:
                return (shift) ? '<' : ',';
            case Input.Keys.PERIOD:
                return (shift) ? '>' : '.';
            case Input.Keys.TAB:
                return TAB;
            case Input.Keys.SPACE:
                return ' ';
            case Input.Keys.ENTER:
                return ENTER;
            case Input.Keys.BACKSPACE:
                return BACKSPACE; // also DEL
            case Input.Keys.GRAVE:
                return (shift) ? '~' : '`';
            case Input.Keys.MINUS:
                return (shift) ? '_' : '-';
            case Input.Keys.EQUALS:
                return (shift) ? '+' : '=';
            case Input.Keys.LEFT_BRACKET:
                return (shift) ? '{' : '[';
            case Input.Keys.RIGHT_BRACKET:
                return (shift) ? '}' : ']';
            case Input.Keys.BACKSLASH:
                return (shift) ? '|' : '\\';
            case Input.Keys.SEMICOLON:
                return (shift) ? ':' : ';';
            case Input.Keys.APOSTROPHE:
                return (shift) ? '"' : '\'';
            case Input.Keys.SLASH:
                return (shift) ? '?' : '/';
            case Input.Keys.AT:
                return '@';
            case Input.Keys.PAGE_UP:
                return PAGE_UP;
            case Input.Keys.PAGE_DOWN:
                return PAGE_DOWN;
        }

        return '\0';
    }

}

