package com.digdes.school.comand;

import com.digdes.school.Lexer;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Update(Values values, Where where) implements Command {

    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) throws Exception {
        for (int i=0; i< table.size(); i++) {
            if (where.evaluate((SqlRow) table.get(i))) {
                table.set(i, values.evaluate((SqlRow) table.get(i)));
            }
        }
        return table;
    }

    public static Update create(Lexer lexer) throws Exception{
        if (!"values".equalsIgnoreCase(lexer.read())) {
            throw new RuntimeException("Update command token, but not values");
        }
        List<String> values = new ArrayList<>();
        while (lexer.hasNext()){
            if (lexer.isNext("where")) {
                values.add(lexer.read());
            } else {
                lexer.read();
                break;
            }
        }
        System.out.println(values);
        List<String> where = new ArrayList<>();
        while (lexer.hasNext()){
            where.add(lexer.read());
        }
        System.out.println(where);
        return new Update(new Values(values), Where.create(where));
    }
}
