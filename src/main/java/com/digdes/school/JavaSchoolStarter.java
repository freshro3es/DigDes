package com.digdes.school;

import com.digdes.school.comand.*;
import com.digdes.school.sql.SqlRow;

import java.util.*;

public class JavaSchoolStarter {

    private List<Map<String,Object>> table = new ArrayList<>();

    //Дефолтный конструктор
    public JavaSchoolStarter(){

    }

    public List<Map<String,Object>> execute(String cmd) throws Exception{
        Lexer lexer = Lexer.create(cmd);
        Command command = createCmd(lexer);
        table = command.evaluate(table);
        return table;
    }

    public static Command createCmd(Lexer lexer) throws Exception {
        String token = lexer.read().toLowerCase();
        return switch (token) {
            case "select" -> Select.create(lexer);
            case "insert" -> Insert.create(lexer);
            case "update" -> Update.create(lexer);
            case "delete" -> Delete.create(lexer);
            default -> throw new IllegalArgumentException("Command \"" + token + "\" does not exist");
        };
    }

    public static void show(List<Map<String,Object>> table) {
        for ( String key : new SqlRow().keySet() ) {
            System.out.print( key + ", " );
        }
        System.out.println();
        if (table.isEmpty()) {
            return;
        }
        SqlRow sqlRow;
        for (Map<String, Object> stringObjectMap : table) {
            sqlRow = (SqlRow) stringObjectMap;
            for (String key : sqlRow.keySet()) {
                System.out.print(sqlRow.get(key) + ", ");
            }
            System.out.println();
        }
    }
}
