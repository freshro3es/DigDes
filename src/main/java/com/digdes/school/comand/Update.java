package com.digdes.school.comand;

import com.digdes.school.Lexer;
import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Update(Values values, Where where) implements Command {

    @Override
    public List<Map<String, Object>> evaluate(List<Map<String, Object>> table) throws Exception {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Update command token, but table is empty");
        }
        if (where!=null) {
            for (int i=0; i< table.size(); i++) {
                if (where.evaluate((SqlRow) table.get(i))) {
                    table.set(i, values.evaluate((SqlRow) table.get(i)));
                }
            }
        } else {
            for (int i=0; i< table.size(); i++) {
                table.set(i, values.evaluate((SqlRow) table.get(i)));
            }
        }
        return table;
    }

    public static Update create(Lexer lexer) throws Exception{
        if (!lexer.hasNext() || !"values".equalsIgnoreCase(lexer.read())) {
            throw new RuntimeException("Update command token, but not values");
        }
        List<String> values = new ArrayList<>();
        while (lexer.hasNext()){
            if (!lexer.isNext("where")) {
                values.add(lexer.read());
            } else {
                lexer.read();
                break;
            }
        }
        System.out.println(values);
        if (values.isEmpty()) {
            throw new IllegalArgumentException("Values to change expected, nothing token");
        }
        if (values.size()%4!=3) {
            throw new IllegalArgumentException("Invalid expression in values statement");
        }
        if (lexer.hasNext()) {
            List<String> where = lexer.readAll();
            System.out.println(where);
            return new Update(new Values(values), Where.create(where));
        } else {
            System.out.println("where is null");
            return new Update(new Values(values), null);
        }
    }
}
