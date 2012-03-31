package ru.ifmo.enf.xando.bolets;

import ru.ifmo.enf.micelius.core.Bolet;
import ru.ifmo.enf.micelius.core.InnerRequest;
import ru.ifmo.enf.micelius.core.InnerResponse;
import ru.ifmo.enf.xando.core.ArtInt;
import ru.ifmo.enf.xando.core.Field;
import ru.ifmo.enf.xando.core.RandomAI;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */
public class XandoBolet implements Bolet {
    Field field = new Field();

    public void process(final InnerRequest request, final InnerResponse response) {
        int[] hw = null;
        ArtInt logic = new RandomAI();

        if (request != null) {
            try {
                String newGame = request.getParameter("newGame");
                if (newGame.equals("yes")) {
                    field = new Field();
                }else{
                    String hwString = request.getParameter("hw");
//                    System.out.println(hwString);
                    int temp = Integer.parseInt(hwString);
                    int h = temp / 10 ;
                    int w = temp % 10 ;
                    field.change(h, w, 'x');
                    hw = logic.doMove(field);
                }

            } catch (NumberFormatException ex) {
                System.out.println("getParameter == null");
            } catch (NullPointerException ex) {
                System.out.println("nullPointerException");
            } //catch (Exception ex) {
                //System.out.println("Other exception");
            //}


            try{
                response.addObject("status", field.getGameStatus());
            }catch (Exception ex){
                System.out.println("status Exc!");
            }
            if (hw != null) {
                response.addObject("hw", (hw[0] ) + "" + (hw[1]));
            }
        } else {
            response.addError("Data Error! request == null!", 2);
        }
    }

}
