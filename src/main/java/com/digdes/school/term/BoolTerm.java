package com.digdes.school.term;

import com.digdes.school.sql.SqlRow;

public class BoolTerm extends Term<Boolean> {

    public BoolTerm(Boolean value) {
        super(value);
    }

    @Override
    public Object getValue(SqlRow sqlRow) {
        return value;
    }
}
