package com.digdes.school.op;

//public class LessOp extends Op<Double, Double> {
//    @Override
//    public boolean apply(Double left, Double right) {
//        return left<right;
//    }
//}

//public class LessOp extends Op<Object, Object> {
//    @Override
//    public boolean apply(Object left, Object right) {
//        if ((left instanceof Number) && (right instanceof Number)) {
//            return ((Number) left).doubleValue()< ((Number) right).doubleValue();
//        }
//        return null;
//    }
//}

//public class LessOp extends Op<Number, Number> {
//    @Override
//    public boolean apply(Number left, Number right) {
//        try {
//            return left.doubleValue()<right.doubleValue();
//        } catch (Exception ex) {
//            throw new RuntimeException();
//        }
//    }
//}

public class LessOp implements Op {
    @Override
    public boolean apply(Object left, Object right) {
        try {
            return ((Number) left).doubleValue()<((Number) right).doubleValue();
        } catch (Exception ex) {
            throw new ClassCastException("Invalid type in Less Operation");
        }
    }
}
