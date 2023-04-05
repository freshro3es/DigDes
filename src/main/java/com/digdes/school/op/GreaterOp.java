package com.digdes.school.op;

public class GreaterOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        //return ((Number) left).doubleValue() > ((Number) right).doubleValue();
        return ((Double) left).compareTo((Double)right)>0;
    }
}
