package com.digdes.school.op;

public class NotEquityOp implements Op {

    @Override
    public boolean apply(Object left, Object right){
        return !left.equals(right);
    }
}
