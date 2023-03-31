package com.digdes.school.term;

import com.digdes.school.sql.SqlRow;

public class DoubleTerm extends Term<Double>{


    public DoubleTerm(Double value) {
        super(value);
    }

    @Override
    public Object getValue(SqlRow sqlRow) {
        return value;
    }
}
