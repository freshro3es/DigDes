package com.digdes.school.logop;

import com.digdes.school.op.LessOp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WhereTest {



    @Test
    void validLongLessOp() {
        boolean expected = true;

        LessOp op= new LessOp();
        boolean actual;
        try {
            actual = op.apply(38L, 40L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void validDoubleLessOp() {
        boolean expected = true;

        LessOp op= new LessOp();
        boolean actual;
        try {
            actual = op.apply(38.3, 40.0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(expected, actual);
    }
}