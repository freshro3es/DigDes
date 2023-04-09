package com.digdes.school.comand;

import com.digdes.school.Lexer;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public record Select(Where where) implements Command{

    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) throws  Exception {
        List<Map<String, Object>> result = new ArrayList<>(table);
        if (where!=null) {
            for (int i=0; i< result.size(); i++) {
                if (!where.evaluate((SqlRow) result.get(i))) {
                    result.remove(i--);
                }
            }
        }
        return result;
    }

    public static Select create(Lexer lexer) throws Exception{
        if (!lexer.hasNext()) {
            return new Select(null);
        }
        if (!"where".equalsIgnoreCase(lexer.read())) {
            throw new IllegalArgumentException("Select command token, but not where");
        }
        if (!lexer.hasNext()) {
            throw new IllegalArgumentException("Where command token, but nothing after");
        }
        List<String> where = lexer.readAll();
        return new Select(Where.create(where));
    }
}