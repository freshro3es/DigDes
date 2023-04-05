package com.digdes.school.op;

public class OrOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        return ((Boolean) left) || ((Boolean) right);
    }
}
