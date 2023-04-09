package com.digdes.school.op;

public class LessOp implements Op {
    @Override
    public boolean apply(Object left, Object right) throws Exception{
       if (left!=null) {
           return ((Number) left).doubleValue()<((Number) right).doubleValue();
       } else {
           return false;
       }
    }
}
