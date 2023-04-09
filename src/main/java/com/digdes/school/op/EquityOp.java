package com.digdes.school.op;

public class EquityOp implements Op {

    @Override
    public boolean apply(Object left, Object right){
        if (left!=null) {
            return left.equals(right);
        } else {
            return false;
        }
    }
}
