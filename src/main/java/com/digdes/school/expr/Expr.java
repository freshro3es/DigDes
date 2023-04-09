package com.digdes.school.expr;

import com.digdes.school.op.Op;
import com.digdes.school.op.OpFactory;
import com.digdes.school.sql.SqlRow;

import java.util.List;

public record Expr(SimpleExpr left, Op op, Expr right, Expr brackets) {

    public static Expr create(List<String> tokens) {
        Expr brackets = null;
        SimpleExpr left = null;
        if ("(".equals(tokens.get(0))) {
            System.out.println(tokens);
            tokens.remove(0);
            brackets = create(tokens);
            System.out.println(tokens);
        } else {
            left = SimpleExpr.create(tokens);
        }
        if (!tokens.isEmpty()) {
            if (!")".equals(tokens.get(0))) {
                Op op = OpFactory.createOp(tokens.remove(0).toLowerCase());
                return new Expr(left, op, create(tokens), brackets);
            } else {
                tokens.remove(0);
            }
        }
        return new Expr(left, null, null, brackets);
    }

    public boolean evaluate(SqlRow sqlRow) throws Exception {
        if (op!=null && right!=null) {
            if (left!=null) {
                return op.apply(left.evaluate(sqlRow), right.evaluate(sqlRow));
            } else {
                return op.apply(brackets.evaluate(sqlRow), right.evaluate(sqlRow));
            }
        }
        if (left!=null) {
            return left.evaluate(sqlRow);
        } else {
            return brackets.evaluate(sqlRow);
        }
    }

}

