package com.digdes.school.comand;

import com.digdes.school.expr.Expr;
import com.digdes.school.sql.SqlRow;

import java.util.List;

public record Where(Expr expr) {

    public static Where create(List<String> tokens) {
        return new Where(Expr.create(tokens));
    }

    public boolean evaluate(SqlRow sqlRow) throws Exception{
        return expr.evaluate(sqlRow);
    }
}
