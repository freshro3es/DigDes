package com.digdes.school.expr;

import com.digdes.school.op.Op;
import com.digdes.school.op.OpFactory;
import com.digdes.school.sql.SqlRow;
import com.digdes.school.term.Term;
import com.digdes.school.term.TermFactory;

import java.util.List;

public record SimpleExpr(Term<?> left, Op op, Term<?> right) {

    public boolean evaluate(SqlRow sqlRow) throws Exception {
        return op.apply(left.getValue(sqlRow), right.getValue(sqlRow));
    }

    public static SimpleExpr create(List<String> tokens) {
        return new SimpleExpr(
            TermFactory.createRefTerm(tokens.remove(0)),
            OpFactory.createOp(tokens.remove(0)),
            TermFactory.createTerm(tokens.remove(0))
        );

    }
}
