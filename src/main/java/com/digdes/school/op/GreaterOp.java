package com.digdes.school.op;

public class GreaterOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        if (left!=null) {
            return ((Number) left).doubleValue() > ((Number) right).doubleValue();
        } else {
            return false;
        }
    }
}
