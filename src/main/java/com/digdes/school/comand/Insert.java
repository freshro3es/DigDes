package com.digdes.school.comand;

import com.digdes.school.Lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Insert(Values values) implements Command {

    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) {
        table.add(values.evaluate());
        return table;
    }

    public static Insert create(Lexer lexer) throws Exception{
        if (!"values".equalsIgnoreCase(lexer.read())) {
            throw new RuntimeException("Insert token, values is not");
        }
        List<String> values = new ArrayList<>();
        while (lexer.hasNext()){
            values.add(lexer.read());
        }
        return new Insert(new Values(values));
    }
}
