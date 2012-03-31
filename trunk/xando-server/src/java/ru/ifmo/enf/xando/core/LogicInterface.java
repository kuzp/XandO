package ru.ifmo.enf.xando.core;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 25.03.12
 */
public interface LogicInterface{
    public void playersMove(final int h, final int w,Field_old field);
    public int [] doMove(Field_old field);
    
}
