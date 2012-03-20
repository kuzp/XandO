package ru.ifmo.enf.xando.bolets;

import ru.ifmo.enf.micelius.core.Bolet;
import ru.ifmo.enf.micelius.core.InnerRequest;
import ru.ifmo.enf.micelius.core.InnerResponse;
import ru.ifmo.enf.xando.core.Field;
import ru.ifmo.enf.xando.core.LogicInt;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */
public class XandoBolet implements Bolet {
    Field field;

    public void process(final InnerRequest request, final InnerResponse response) {
        if (request != null) {
            try {
                try {
                    System.out.println(request.getParameter("h"));
                    int h = Integer.parseInt(request.getParameter("h"));
                    int w = Integer.parseInt(request.getParameter("w"));
                    field.change(h, w, 'x');
                } catch (NumberFormatException ex) {
                    System.out.println("getParameter == null");
                }

                int[] hw = LogicInt.doMove(field);
                if (hw == null) {
                    response.addObject("status", field.getGameStatus());
                } else {
                    response.addObject("hw", hw);
                }

            } catch (NumberFormatException ex) {
                response.addError(ex.getMessage(), 1);
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                response.addError(ex.getMessage(), 1);
            }
        } else {

            response.addObject("trololo", "loloshto?");
        }
    }

}
