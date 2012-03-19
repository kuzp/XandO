package ru.ifmo.enf.xando.core;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 19.03.12
 */
public class Test {
    @org.junit.Test
    public void testTest() throws Exception {
        Field f1 = LogicInt.doMove(new Field());
        System.out.println(f1.toString());
    }
}
