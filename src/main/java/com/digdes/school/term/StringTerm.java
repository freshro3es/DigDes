package com.digdes.school.term;

import com.digdes.school.sql.SqlRow;

public class StringTerm extends Term<String>{

    public StringTerm(String value) {
        super(value);
    }

    @Override
    public Object getValue(SqlRow sqlRow) {
        return value;
    }
}
