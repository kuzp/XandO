package ru.ifmo.enf.xando.core;

/**
 * Authors: Kuznetsov Pavel (palmihal@gmail.com)
 * Losevskoy Max (maxlosevskoy@ya,ru)
 * Date: 19.03.12
 */
public class Field_old {
    private final int size;
    private char[][] a;
    private char playersChar = 'x';
    private int gameStatus = 0;   // 0 - in progress , 1 for CPU win, 2 for Player win, 3 for draw;
    private char aiChar = 'o';

    public Field_old(final int s) {
        this.size = s;
        a = new char[s][s];
        for (int i = 0; i < s; i++){
            for (int j = 0; j < s; j++){
                a[i][j] = 'e';
            }

        }
    }

    public Field_old() {
        this(3);
    }

    public static Field_old fieldCopy(Field_old original) {
        Field_old copy = new Field_old(original.size);
        copy.playersChar = original.playersChar;
        copy.aiChar = original.aiChar;
        for (int i = 0; i < original.size; i++) {
            System.arraycopy(original.a[i], 0, copy.a[i], 0, original.size);
        }
        return copy;
    }

    public char[][] fieldToArray(final Field_old f) {
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

/*public void restart(Field_old field){
    field = new Field_old(this.size,  this.width);
}*/
}