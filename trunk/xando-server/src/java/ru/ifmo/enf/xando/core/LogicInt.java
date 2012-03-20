package ru.ifmo.enf.xando.core;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */

/*
 * данный класс реализует логику ИИ
 */
public class LogicInt{
    public static int [] doMove(Field field){
        int h = field.getHeight();
        int w = field.getWidth();
        for (int i = 0; i < h; i++ ){
            for (int j = 0; j < w; j++){
                if (field.getElement(i,j) == 'e'){
                    field.change(i,j, field.getAiChar() );
                    int [] a = {i,j};
                    return a;
                }
            }
        }
        field.setGameStatus(3);
        return null;
    }
}

