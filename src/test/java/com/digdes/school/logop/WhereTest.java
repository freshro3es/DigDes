package com.digdes.school.logop;

import com.digdes.school.expr.Where;
import com.digdes.school.op.LessOp;
import com.digdes.school.op.Op;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WhereTest {

    @Test
    void create() {
        Where.create("'test'!=5");
    }

    @Test
    void validLongLessOp() {
        boolean expected = true;

        LessOp op= new LessOp();
        boolean actual = op.apply(38L, 40L);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void invalidLongLessOp() {
        ClassCastException expected = new ClassCastException("Invalid type in Less Operation"), actual;

        boolean ty;
        Op op = new LessOp();
        try {
            ty = op.apply("kdfha", "ldfngla");
        } catch (ClassCastException ex) {
            actual = ex;
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }
    }

    @Test
    void validDoubleLessOp() {
        boolean expected = true;

        LessOp op= new LessOp();
        boolean actual = op.apply(38.3, 40.0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void invalidDoubleLessOp() {
        ClassCastException expected = new ClassCastException("Invalid type in Less Operation"), actual;

        boolean ty;
        Op op = new LessOp();
        try {
            ty = op.apply(40, "ldfngla");
        } catch (ClassCastException ex) {
            actual = ex;
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }
    }
}