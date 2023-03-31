package com.digdes.school.term;

import com.digdes.school.sql.SqlRow;

public abstract class Term<Type> {

    Type value;

    public Term(Type value) {
        this.value = value;
    }

    public abstract Object getValue(SqlRow sqlRow);

}
