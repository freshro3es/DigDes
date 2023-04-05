package com.digdes.school.assignment;

import com.digdes.school.sql.SqlRow;
public record SimpleAss(String key, Object value) {

    public SqlRow evaluate(SqlRow sqlRow) {
        sqlRow.put(key, value);
        return sqlRow;
    }
}
