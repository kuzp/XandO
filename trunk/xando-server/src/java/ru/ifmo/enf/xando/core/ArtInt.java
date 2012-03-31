package ru.ifmo.enf.xando.core;

/**
 * Created by Max Losevskoy (magistrsmi@yandex.ru)
 * 3:43 30.03.12
 */
public interface ArtInt {
    /**
     * Chooses position to put PC's symbol to
     * and makes a move if possible, checks out for a win
     * @param field - current game field
     * @return array with coordinates of marked
     * cell or null for a draw game situation
     */
    int[] doMove(final Field field);

    /**
     * Checks out if player marks correct cell
     * and changes field according to his move
     * @param h - height of desired cell
     * @param w - width of desired cell
     * @param field - current game field
     */
     void playersMove(final int h, final int w, final Field field);

}
