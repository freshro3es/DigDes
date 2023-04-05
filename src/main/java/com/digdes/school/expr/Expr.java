package com.digdes.school.expr;

import com.digdes.school.op.Op;
import com.digdes.school.op.OpFactory;
import com.digdes.school.sql.SqlRow;

import java.util.List;

public record Expr(SimpleExpr left, Op op, Expr right) {

    public static Expr create(List<String> tokens) {
        SimpleExpr left = SimpleExpr.create(tokens);
        if (!tokens.isEmpty()) {
            Op op = OpFactory.createOp(tokens.remove(0).toLowerCase());
            return new Expr(left, op, create(tokens));
        }
        return new Expr(left, null, null);
    }

    public boolean evaluate(SqlRow sqlRow) throws Exception {
        if (op!=null && right!=null) {
            return op.apply(left.evaluate(sqlRow), right.evaluate(sqlRow));
        }
        return left.evaluate(sqlRow);
    }

}
