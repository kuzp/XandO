package ru.ifmo.enf.xando.core;

import java.util.Random;

/**
 * Created by Max Losevskoy (magistrsmi@yandex.ru)
 * 3:32 30.03.12
 */
public class RandomAI implements ArtInt {

    int[][] winComb;   // Победная линия

    public int[] doMove(final Field field) {
        winComb = new int[field.getSize()][2];
        if (!drawCheck(field)) {
            Random rand = new Random();
            int i;
            int j;
            for (; ; ) {
                i = rand.nextInt(field.getSize());
                j = rand.nextInt(field.getSize());
                if (field.getCell(i, j) == 'e') {
                    field.change(i, j, field.getAiChar());
                    break;
                }
            }
            if (win(field)) {
                field.setGameStatus(2);
            }
            drawCheck(field);
            return new int[]{i, j};
        }
        return null;
    }

    public void playersMove(final int h, final int w, final Field field) {
        if (drawCheck(field)) {
            return;
        }
        if (field.getCell(h, w) != 'e') {
            System.out.println("Cell's Not Empty! \n Choose Empty Cell Please!");
            return;
        }
        field.change(h, w, field.getPlayersChar());
        if (win(field)) {
            field.setGameStatus(1);
            return;
        }
        drawCheck(field);
    }

    private boolean drawCheck(final Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getCell(i, j) == 'e') {
                    return false;
                }
            }
        }
        field.setGameStatus(3);
        return true;
    }

    private boolean win(final Field f) {
        char[][] chk = f.fieldToArray(f);
        boolean flag = true;
        int i = 0;
        while (i < f.getSize() - 1 && flag) {
            flag = (chk[i][i] == chk[i + 1][i + 1] && chk[i][i] != 'e');
            i++;
        }
        if (flag) {
            for (int win = 0; win < f.getSize(); win++) {
                winComb[win] = new int[]{win, win};
            }
            return true;
        }
        flag = true;
        i = 0;
        while (i < f.getSize() - 1 && flag) {
            flag = chk[i][f.getSize() - i - 1] == chk[i + 1][f.getSize() - i - 2] && chk[i][f.getSize() - i - 1] != 'e';
            i++;
        }
        if (flag) {
            for (int win = 0; win < f.getSize(); win++) {
                winComb[win] = new int[]{win, f.getSize() - i};
            }
            return true;
        }
        i = 0;
        int j;
        while (i < f.getSize()) {
            if (flag) {
                for (int win = 0; win < f.getSize(); win++) {
                    winComb[win] = new int[]{i, win};
                }
                return true;
            }
            for (j = 0; j < f.getSize() - 1; j++) {
                if (chk[i][j] == chk[i][j + 1] && chk[i][j] != 'e') {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            i++;
        }
        i = 0;
        while (i < f.getSize()) {
            if (flag) {
                for (int win = 0; win < f.getSize(); win++) {
                    winComb[win] = new int[]{win, i};
                }
                return true;
            }
            for (j = 0; j < f.getSize() - 1; j++) {
                if (chk[j][i] == chk[j + 1][i] && chk[j][i] != 'e') {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            i++;
        }
        return false;
    }
}
