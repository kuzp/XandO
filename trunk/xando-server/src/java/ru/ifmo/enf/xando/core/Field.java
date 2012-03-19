package ru.ifmo.enf.xando.core;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */
public class Field {
    private final int height;
    private final int width;
    private char[][] a;
    private char playersChar = 'x';
    private char aiChar = 'o';

    public Field(final int h, final int w) {
        this.height = h;
        this.width = w;
        a = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = 'e';
            }
        }
    }

    public Field() {
        this(3, 3);
    }

    /*
    * изменяет один элемент и возвращает из мененный Field
    */
    public void change(final int h, final int w, char value) {
        a[h][w] = value;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public char getElement(final int h, final int w) {
        return a[h][w];

    }

    public char getPlayersChar() {
        return playersChar;
    }

    public void setPlayersChar(char ch) {
        this.playersChar = ch;
//        if (ch == 'x') {
//            this.playersChar = 'x';
//            this.aiChar = 'o';
//        }
//        if (ch == 'o') {
//            this.playersChar = 'o';
//            this.aiChar = 'x';
//        }
    }
    public int  gameStatus(){
        return 0; // 0 - in progress , 1 - x won, 2 - o won, 3 - drawn game;
    }
}
