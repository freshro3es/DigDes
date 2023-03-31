package com.digdes.school.expr;

import com.digdes.school.op.Op;
import com.digdes.school.sql.SqlRow;
import com.digdes.school.term.Term;
import com.digdes.school.term.TermFactory;

import static com.digdes.school.op.OpFactory.createOp;

public class SimpleExpr {

    private Term<?> left;
    private Op op;
    private Term<?> right;


    public SimpleExpr(Term<?> left, Op op, Term<?> right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public boolean evaluate(SqlRow sqlRow) {
        return op.apply(left.getValue(sqlRow), right.getValue(sqlRow));
    }
}
