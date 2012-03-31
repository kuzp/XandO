package ru.ifmo.enf.xando.core;

import junit.framework.TestCase;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */
public class Test extends TestCase{
    public void testBlaBla() throws Exception {
        int [] f1 = LogicIntSimple.doMove(new Field_old());
        System.out.println(f1.toString());
        String s = "12";

    }
}
