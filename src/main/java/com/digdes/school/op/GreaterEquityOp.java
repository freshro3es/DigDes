package com.digdes.school.op;

public class GreaterEquityOp implements Op {

    @Override
    public boolean apply(Object left, Object right) {
        System.out.println(left);
        System.out.println(right);
        try {
            return ((Number) left).doubleValue()>=((Number) right).doubleValue();
        } catch (Exception ex) {
            throw new ClassCastException("Invalid type in Greater Equity Operation");
        }
    }
}

