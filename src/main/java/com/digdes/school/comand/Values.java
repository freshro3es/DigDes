package com.digdes.school.comand;

import com.digdes.school.assignment.Ass;
import com.digdes.school.sql.SqlRow;

import java.util.List;

public class Values {

    private final List<String> tokens;

    public Values(List<String> tokens) {
        this.tokens = tokens;
    }

    public SqlRow evaluate() {
        return Ass.createAss(tokens).evaluate(new SqlRow());
    }

    public SqlRow evaluate(SqlRow sqlRow) {
        return Ass.createAss(tokens).evaluate(sqlRow);
    }
}
