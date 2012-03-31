package ru.ifmo.enf.xando.core;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */

/*
 * данный класс реализует логику ИИ
 */
public class LogicIntSimple {
    public static int [] doMove(Field_old field){
        boolean flag;
        int s = field.getSize();
        for (int i = 0; i < s; i++ ){
            for (int j = 0; j < s; j++){
                if (field.getCell(i,j) == 'e'){
                    field.change(i,j, 'o' );
                    int [] a = {i,j};
                    return a;
                }
            }
        }
        for (int i=0; i < s; i++){

        }
        field.setGameStatus(3);
        return null;
    }
}

