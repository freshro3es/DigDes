package com.digdes.school.expr;

import com.digdes.school.op.Op;
import com.digdes.school.op.OpFactory;
import com.digdes.school.sql.SqlRow;
import com.digdes.school.term.TermFactory;

import java.util.List;

public class Expr {

    SimpleExpr left;
    Op op;
    Expr right;


    public Expr(SimpleExpr expr) {
        this.left = expr;
    }

    public Expr(SimpleExpr left, Op op, Expr right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public static Expr createExpr(List<String> tokens) throws Exception {
        SimpleExpr left = new SimpleExpr(
                TermFactory.createRefTerm(tokens.remove(0)),
                OpFactory.createOp(tokens.remove(0)),
                TermFactory.createTerm(tokens.remove(0))
        );
        if (!tokens.isEmpty()) {
            try {
                Op op = OpFactory.createOp(tokens.remove(0).toLowerCase());
                return new Expr(left, op, createExpr(tokens));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return new Expr(left);
    }

    public boolean evaluate(SqlRow sqlRow) {
        if ((op!=null) && (right!=null)) {
            return op.apply(left.evaluate(sqlRow), right.evaluate(sqlRow));
        }
        return left.evaluate(sqlRow);
    }

}
