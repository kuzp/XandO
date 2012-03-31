package ru.ifmo.enf.xando.core;

/**
 * Created by Max Losevskoy
 * Date: 19.03.12
 */

/*
 * данный класс реализует логику ИИ
 */
public class LogicInt_ {
    private static boolean cpu = false;
    public static int[] doMove(Field_old field) {
        int s = field.getSize();
        int[] last = new int[]{-1, -1};
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (field.getCell(i, j) == 'e') {
                    last = new int[]{i, j};
                    if (LogicInt_.check(i, j, field)) {
                        field.change(i, j, field.getAiChar());
                        if(cpu){
                            field.setGameStatus(2);
                        }
                        return new int[]{i, j};
                    }

                }
            }
        }
        field.change(last[0], last[1], field.getAiChar());
        drawCheck(field);
        return last;
    }

    private static boolean drawCheck(final Field_old field) {
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

    public void playersMove(final int h, final int w, final Field_old field) {
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

    private static boolean check(final int h, final int w, final Field_old fld) {
        final Field_old chField = Field_old.fieldCopy(fld);
        chField.change(h, w, chField.getAiChar());
        if (LogicInt_.win(chField)) {
            cpu = true;
            return true;
        } else {
            chField.change(h, w, chField.getPlayersChar());
            if (LogicInt_.win(chField)) {
                return true;
            }
        }
        return false;
    }

    private static boolean win(final Field_old f) {
        char[][] chk = f.fieldToArray(f);
        boolean flag = true;
        int i = 0;
        while (i < f.getSize() - 1 && flag) {
            flag = (chk[i][i] == chk[i + 1][i + 1] && chk[i][i] != 'e');
            i++;
        }
        if (flag) {
            return true;
        }
        flag = true;
        i = 0;
        while (i < f.getSize() - 2 && flag) {
            flag = chk[i][f.getSize() - i - 1] == chk[i + 1][f.getSize() - i - 2] && chk[i][f.getSize() - i - 1] != 'e';
            i++;
        }
        if (flag) {
            return true;
        }
        i = 0;
        int j;
        while (i < f.getSize()) {
            if (flag) {
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
        while (i < f.getSize()) {
            if (flag) {
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