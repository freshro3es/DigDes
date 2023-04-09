package com.digdes.school.assignment;

import com.digdes.school.sql.SqlRow;
import com.digdes.school.term.TermFactory;

import java.util.List;
import java.util.Objects;

public record Ass(SimpleAss left, Ass right) {

    public static Ass createAss(List<String> tokens) {
        String key = ((String) Objects.requireNonNull(TermFactory.createTerm(tokens.remove(0))).getValue(null)).toLowerCase();
        Object value;
        if (!"null".equals(tokens.get(1))) {
            value = Objects.requireNonNull(TermFactory.createTerm(tokens.remove(1))).getValue(null);
        } else {
            value = null;
            tokens.remove(1);
        }
        SimpleAss left;
        if ("=".equals(tokens.remove(0))) {
            left = new SimpleAss(key, value);
        } else {
            throw new RuntimeException("Assignment operator expected, but another token");
        }
        if (!tokens.isEmpty()) {
            if (",".equals(tokens.remove(0))) {
                return new Ass(left, createAss(tokens));
            } else {
                throw new IllegalArgumentException("Invalid expression in values statement: \",\" expected");
            }
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

