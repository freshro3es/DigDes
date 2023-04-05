package com.digdes.school.sql;

import java.util.HashMap;
import java.util.Map;

public class SqlRow extends HashMap<String, Object> {

    public SqlRow() {
        super(rowSample());
    }

    @Override
    public Object put(String key, Object value) {
        if (containsKey(key)) {
            if (!validate(key, value)) {
                throw new IllegalArgumentException("Value \"" + value + "\" does not match to the \"" + key + "\" column value type");
            }
            super.put(key, value);
        } else {
            throw new RuntimeException("Column name \"" + key + "\" does not exist ");
        }
        return null;
    }

    public static Map<String, Object> rowSample() {
        Map<String, Object> sqlRow = new HashMap<>();
        sqlRow.put("id", null);
        sqlRow.put("lastname", null);
        sqlRow.put("age", null);
        sqlRow.put("cost", null);
        sqlRow.put("active", null);
        return sqlRow;
    }

    private static boolean validate(String key, Object value) {
        return switch (key) {
            case "id", "age" -> value instanceof Long;
            case "lastname" -> value instanceof String;
            case "cost" -> value instanceof Double;
            case "active" -> value instanceof Boolean;
            default -> false;
        };
    }
}
