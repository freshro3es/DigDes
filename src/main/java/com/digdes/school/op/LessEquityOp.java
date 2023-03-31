package com.digdes.school.op;

public class LessEquityOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        try {
            return ((Number) left).doubleValue()<=((Number) right).doubleValue();
        } catch (Exception ex) {
            throw new ClassCastException("Invalid type in Less Equity Operation");
        }
    }
}
