package ru.ifmo.enf.xando.core;

/**
 * Created by Max Losevskoy
 * Date: 19.03.12
 */

/*
 * данный класс реализует логику ИИ
 */
public class LogicInt implements ArtInt {

    int[][] winComb;    // Победная линия

    public int[] doMove(Field field) {
        winComb = new int[field.getSize()][2];
        if (!drawCheck(field)) {
            int[] veryLast = new int[]{-1, -1};
            int[] last = new int[]{-1, -1};
            for (int i = 0; i < field.getSize(); i++) {
                for (int j = 0; j < field.getSize(); j++) {
                    if (field.getCell(i, j) == 'e') {
                        switch (check(i, j, field)) {
                            case 0: {
                                veryLast[0] = i;
                                veryLast[1] = j;
                            }
                            case 1: {
                                field.change(i, j, field.getAiChar());
                                field.setGameStatus(2);
                                return new int[]{i, j};
                            }
                            case 2: {
                                last[0] = i;
                                last[1] = j;
                            }
                        }
                    }
                }
            }
            if (last[0] != -1) {
                field.change(last[0], last[1], field.getAiChar());
                drawCheck(field);
                return last;
            } else {
                field.change(veryLast[0], veryLast[1], field.getAiChar());
                drawCheck(field);
                return veryLast;
            }
        }
        return null;
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

    private int check(final int h, final int w, final Field fld) {
        final Field chField = fld.fieldCopy(fld);
        chField.change(h, w, chField.getAiChar());
        if (win(chField)) {
            return 1;
        } else {
            chField.change(h, w, chField.getPlayersChar());
            if (win(chField)) {
                return 2;
            }
        }
        return 0;
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

