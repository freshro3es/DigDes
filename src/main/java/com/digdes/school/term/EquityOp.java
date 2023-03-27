package com.digdes.school.term;

public class EquityOp {

    public boolean value(BoolTerm left, BoolTerm right) {
        return left.value()==right.value();
    }

}
