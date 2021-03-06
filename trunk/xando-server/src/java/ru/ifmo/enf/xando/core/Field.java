package ru.ifmo.enf.xando.core;

/**
 * Authors: Kuznetsov Pavel (palmihal@gmail.com)
 * Losevskoy Max (maxlosevskoy@ya.ru)
 * Date: 19.03.12
 */
public class Field {
    private final int size;
    private char[][] a;
    private char playersChar = 'x';
    private int gameStatus = 0;   // 0 - in progress ,1 for Player win, 2 for CPU win,  3 for draw;
    private char aiChar = 'o';

    public Field(final int s) {
        this.size = s;
        a = new char[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                a[i][j] = 'e';
            }
        }
    }

    public Field() {
        this(5);
    }

    public Field fieldCopy(Field original) {
        Field copy = new Field(original.size);
        copy.playersChar = original.playersChar;
        copy.aiChar = original.aiChar;
        for (int i = 0; i < original.size; i++) {
            for (int j = 0; j < original.size; j++) {
                copy.change(i, j, original.getCell(i, j));
            }
        }
        return copy;
    }

    public char[][] fieldToArray(final Field f) {
        char[][] res = new char[f.size][f.size];
        System.arraycopy(f.a, 0, res, 0, f.a.length);
        return res;
    }

    public void change(final int h, final int w, char value) {
        if (h <= size && w <= size) {
            a[h][w] = value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getSize() {
        return this.size;
    }


    public char getCell(final int h, final int w) {
        return a[h][w];

    }

    public char getAiChar() {
        return aiChar;
    }

    public char getPlayersChar() {
        return playersChar;
    }

    public void setChar(char ch) {
        if (ch == 'x') {
            this.playersChar = 'x';
            this.aiChar = 'o';
        } else {
            this.playersChar = 'o';
            this.aiChar = 'x';
        }
    }

    public int getGameStatus() {
        return gameStatus; // 0 - in progress , 1 for "x" win, 2 for "o" win, 3 for draw;
    }

    public void setGameStatus(int status) {
        this.gameStatus = status;
    }

    /*public void restart(Field field){
        field = new Field(this.size,  this.width);
    }*/
}
