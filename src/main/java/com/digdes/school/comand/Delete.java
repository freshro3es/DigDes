package com.digdes.school.comand;

import com.digdes.school.Lexer;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Delete(Where where) implements Command {
    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) throws Exception{
        for (int i=0; i<table.size(); i++) {
            if (where.evaluate((SqlRow) table.get(i))) {
                table.remove(i--);
            }
        }
        return table;
    }

    public static Delete create(Lexer lexer) throws Exception{
        if (!"where".equalsIgnoreCase(lexer.read())) {
            throw new IllegalArgumentException("Delete command token, but not where");
        }
        List<String> where = new ArrayList<>();
        while (lexer.hasNext()){
            where.add(lexer.read());
        }
        return new Delete(Where.create(where));
    }
}
