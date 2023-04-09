package com.digdes.school.comand;

import com.digdes.school.assignment.Ass;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;

public class Values {

    private final List<String> tokens;

    public Values(List<String> tokens) {
        this.tokens = tokens;
    }

    public SqlRow evaluate() {
        SqlRow row = Ass.createAss(tokens).evaluate(new SqlRow());
        int count = 0;
        for (String key : row.keySet()) {
            if (row.get(key)==(null)) {
                count++;
            }
        }
        if (count!=row.size()) {
            return row;
        }
        throw new IllegalArgumentException("Empty values token in Insert");
    }

    public SqlRow evaluate(SqlRow sqlRow) {
        SqlRow row = Ass.createAss(new ArrayList<>(tokens)).evaluate(sqlRow);
        int count = 0;
        for (String key : row.keySet()) {
            if (row.get(key)==(null)) {
                count++;
            }
        }
        if (count!=row.size()) {
            return row;
        }
        throw new IllegalArgumentException("Row in table become empty after Update");
    }
}
