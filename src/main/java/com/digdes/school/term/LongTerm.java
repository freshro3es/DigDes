package com.digdes.school.term;

import com.digdes.school.sql.SqlRow;

public class LongTerm extends Term<Long> {

    public LongTerm(Long value) {
        super(value);
    }

    @Override
    public Object getValue(SqlRow sqlRow) {
        return value;
    }
}
