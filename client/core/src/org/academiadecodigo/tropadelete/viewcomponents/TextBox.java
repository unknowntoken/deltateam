package org.academiadecodigo.tropadelete.viewcomponents;

import java.awt.*;

public class TextBox {

    private Rectangle textBox;

    private int width;
    private int height;

    private int x;
    private int y;

    public TextBox(){

        this.textBox = new Rectangle();

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.textBox.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.textBox.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.textBox.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.textBox.y = y;
    }
}
