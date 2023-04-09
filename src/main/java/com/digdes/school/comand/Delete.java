package com.digdes.school.comand;

import com.digdes.school.Lexer;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Delete(Where where) implements Command {
    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) throws Exception{
        List<Map<String, Object>> result = new ArrayList<>();
        if (where!=null) {
            for (int i=0; i<table.size(); i++) {
                if (where.evaluate((SqlRow) table.get(i))) {
                    result.add(table.remove(i--));
                }
            }
        } else {
            for (int i=0; i<table.size(); i++) {
                result.add(table.remove(i--));
            }
        }
        return result;
    }

    public static Delete create(Lexer lexer) throws Exception{
        if (!lexer.hasNext()) {
            return new Delete(null);
        }
        if (!"where".equalsIgnoreCase(lexer.read())) {
            throw new IllegalArgumentException("Delete command token, but not where");
        }
        if (!lexer.hasNext()) {
            throw new IllegalArgumentException("Where command token, but nothing after");
        }
        List<String> where = lexer.readAll();
        return new Delete(Where.create(where));
    }
}
