package com.digdes.school.assignment;

import com.digdes.school.sql.SqlRow;
import com.digdes.school.term.TermFactory;

import java.util.List;
import java.util.Objects;

public record Ass(SimpleAss left, Ass right) {

    public static Ass createAss(List<String> tokens) {
        String key = ((String) Objects.requireNonNull(TermFactory.createTerm(tokens.remove(0))).getValue(null)).toLowerCase();
        Object value = Objects.requireNonNull(TermFactory.createTerm(tokens.remove(1))).getValue(null);
        SimpleAss left;
        if ("=".equals(tokens.remove(0))) {
            left = new SimpleAss(key, value);
        } else {
            throw new RuntimeException("Assignment operator expected, but another token");
        }
        if (!tokens.isEmpty() && ",".equals(tokens.remove(0))) {
            return new Ass(left, createAss(tokens));
        }
        return new Ass(left, null);
    }

    public SqlRow evaluate(SqlRow sqlRow) {
        if (right!=null) {
            return right.evaluate(left.evaluate(sqlRow));
        }
        return left.evaluate(sqlRow);
    }
}

