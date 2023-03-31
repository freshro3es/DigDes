package com.digdes.school.term;

import com.digdes.school.sql.SqlRow;

public class RefTerm extends Term<String> {
    public RefTerm(String value) {
        super(value);
    }

    @Override
    public Object getValue(SqlRow sqlRow) {
        return sqlRow.get(value);
    }

}
