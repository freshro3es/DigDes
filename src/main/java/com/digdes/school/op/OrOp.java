package com.digdes.school.op;

public class OrOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        try {
            return ((Boolean) left) || ((Boolean) right);
        } catch (Exception ex) {
            throw new RuntimeException("\"Этого не произойдет\"");
        }
    }
}
