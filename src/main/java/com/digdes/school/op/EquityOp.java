package com.digdes.school.op;

public class EquityOp implements Op {

    @Override
    public boolean apply(Object left, Object right){
        return left.equals(right);
    }
}
