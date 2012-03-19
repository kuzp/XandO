package ru.ifmo.enf.xando.core;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */
public class LogicInt{
    public static Field doMove(Field field, char symbol){
        int h = field.getHeight();
        int w = field.getWidth();
        for (int i = 0; i < h; i++ ){
            for (int j = 0; j < w; j++){
                if (field.getElement(i,j) == 'e'){
                    field.change(i,j,'x');
                }
            }
        }
        return field;
    }
}

