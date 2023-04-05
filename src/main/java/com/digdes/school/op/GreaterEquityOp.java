package com.digdes.school.op;

public class GreaterEquityOp implements Op {

    @Override
    public boolean apply(Object left, Object right) throws Exception {
        //return ((Number) left).doubleValue()>=((Number) right).doubleValue();
        return ((Double) left).compareTo((Double)right)>=0;
    }
}

