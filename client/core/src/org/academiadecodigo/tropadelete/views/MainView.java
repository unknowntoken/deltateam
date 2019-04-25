package org.academiadecodigo.tropadelete.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import org.academiadecodigo.tropadelete.MessageHandler;
import org.academiadecodigo.tropadelete.networking.ConnectionHandler;


import static com.badlogic.gdx.Input.Keys.*;


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

    private ShapeRenderer userListPanel;

    private ConnectionHandler server;

    public void setConnectionHandler(ConnectionHandler server) {
        this.server = server;
    }


    public void incommingMessage(String message) {

        message_field.appendText(message);

    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        stage = new Stage();

        background = new Texture("graphics/welcome_background-01_1920x1080.png");
        chatBox = new Texture("graphics/chat_view-01.png");

        backgroundRec = new Rectangle();
        backgroundRec.x = 0;
        backgroundRec.y = 0;
        backgroundRec.width = 1920;
        backgroundRec.height = 1080;

        chatBoxRec = new Rectangle();
        chatBoxRec.x = 160;
        chatBoxRec.y = 200;
        chatBoxRec.width = 1600;
        chatBoxRec.height = 675;

        TextField.TextFieldStyle messageStyle = new TextField.TextFieldStyle();
        messageStyle.fontColor = Color.BLACK;
        messageStyle.font = new BitmapFont();

        TextField.TextFieldStyle inputStyle = new TextField.TextFieldStyle();
        inputStyle.fontColor = Color.BLACK;
        inputStyle.font = new BitmapFont();

        message_field = new TextArea("", messageStyle);
        message_field.setWidth(860);
        message_field.setHeight(460);
        message_field.setPosition(530, 310);
        message_field.toFront();

        userListPanel = new ShapeRenderer();

        border = new ShapeRenderer();
        messageFieldBackground = new ShapeRenderer();

        inputMessage = new TextField("", inputStyle);
        inputMessage.setPosition(540, 220);
        inputMessage.setSize(700, 50);

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
        imagesRender();

        stage.draw();
        stage.act();

        userListPanel.begin(ShapeRenderer.ShapeType.Filled);
        userListPanel.rect(1570, 205, 200, 665);
        userListPanel.setColor(Color.WHITE);
        userListPanel.end();

    }

    private void borderAndBackground(Widget element) {

        border.begin(ShapeRenderer.ShapeType.Filled);
        border.setColor(Color.BLACK);
        border.rect(element.getX() - 5, element.getY() - 5, element.getWidth() + 10, element.getHeight() + 10);
        border.end();

        border.begin(ShapeRenderer.ShapeType.Filled);
        border.setColor(Color.WHITE);
        border.rect(element.getX(), element.getY(), element.getWidth(), element.getHeight());
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

        boolean alt =  Gdx.input.isKeyPressed(ALT_LEFT) || Gdx.input.isKeyPressed(ALT_RIGHT),
                ctrl =  Gdx.input.isKeyPressed(CONTROL_LEFT) || Gdx.input.isKeyPressed(CONTROL_RIGHT),
                shift = Gdx.input.isKeyPressed(SHIFT_LEFT) || Gdx.input.isKeyPressed(SHIFT_RIGHT);

        char c = fromCode(keycode, shift);

        inputMessage.appendText(String.valueOf(c));
        if (Gdx.input.isKeyPressed(ENTER)){
            server.sendMessageToServer(inputMessage.getText());
            inputMessage.setText("");
        }

        return false;
    }

    private void imagesRender() {

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

    public char fromCode(int keycode, boolean shift){
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
                return (shift) ? '>' :'.';
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
                return (shift) ? '+' :'=';
            case Input.Keys.LEFT_BRACKET:
                return (shift) ? '{' :'[';
            case Input.Keys.RIGHT_BRACKET:
                return (shift) ? '}' :']';
            case Input.Keys.BACKSLASH:
                return (shift) ? '|' :'\\';
            case Input.Keys.SEMICOLON:
                return (shift) ? ':' :';';
            case Input.Keys.APOSTROPHE:
                return (shift) ? '"' :'\'';
            case Input.Keys.SLASH:
                return (shift) ? '?' :'/';
            case Input.Keys.AT:
                return '@';
            case Input.Keys.PAGE_UP:
                return PAGE_UP;
            case Input.Keys.PAGE_DOWN:
                return PAGE_DOWN;
        }

        return '\0';
    }

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
     * Enter key, also called Return key. Used to start a new line of text or confirm entries in forms.
     */
    public static final char ENTER = '\u21B5';
    /**
     * Tab key. Used for entering horizontal spacing, such as indentation, but also often to cycle between menu items.
     */
    public static final char TAB = '\u21B9';
    /**
     * Backspace key on most PC keyboards; Delete key on Mac keyboards. Used to delete the previous character.
     */
    public static final char BACKSPACE = '\u2280';
    /**
     * Delete key on most PC keyboards; no equivalent on some (all?) Mac keyboards. Used to delete the next character.
     *
     * Not present on some laptop keyboards and some (all?) Mac keyboards.
     */
    public static final char FORWARD_DELETE = '\u2281';
    /**
     * Insert key. Not recommended for common use because it could affect other application behavior.
     *
     * Not present on some laptop keyboards.
     */
    public static final char INSERT = '\u2208';
    /**
     * Page Down key.
     *
     * Not present on some laptop keyboards.
     */
    public static final char PAGE_DOWN = '\u22A4';
    /**
     * Page Up key.
     *
     * Not present on some laptop keyboards.
     */
    public static final char PAGE_UP = '\u22A5';
    /**
     * Home key (commonly used for moving a cursor to start of line).
     *
     * Not present on some laptop keyboards.
     */
    public static final char HOME = '\u2302';
    /**
     * End key (commonly used for moving a cursor to end of line).
     *
     * Not present on some laptop keyboards.
     */
    public static final char END = '\u2623';
    /**
     * Esc or Escape key
     */
    public static final char ESCAPE = '\u2620';

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
