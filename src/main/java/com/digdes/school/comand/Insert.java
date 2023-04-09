package com.digdes.school.comand;

import com.digdes.school.Lexer;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Insert(Values values) implements Command {

    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) {
        SqlRow sqlRow = values.evaluate();
        List<Map<String, Object>> result = new ArrayList<>(List.of(sqlRow));
        table.add(sqlRow);
        return result;
    }

    public static Insert create(Lexer lexer) throws Exception{
        if (!lexer.hasNext() || !"values".equalsIgnoreCase(lexer.read())) {
            throw new RuntimeException("Insert token, values is not");
        }
        List<String> values = new ArrayList<>();
        while (lexer.hasNext()){
            values.add(lexer.read());
        }
        return new Insert(new Values(values));
    }
}
