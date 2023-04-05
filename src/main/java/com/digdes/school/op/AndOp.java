package com.digdes.school.op;

public class AndOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        return ((Boolean) left) && ((Boolean) right);
    }
}
