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
        Lexer lexer = new Lexer(cmd);
        Command command = createCmd(lexer);
        table = command.evaluate(table);

        return table;
    }

    public static Command createCmd(Lexer lexer) throws Exception {
        String token = lexer.read().toLowerCase();
        System.out.println(token);
        return switch (token) {
            case "select" -> Select.create(lexer);
            case "insert" -> Insert.create(lexer);
            case "update" -> Update.create(lexer);
            case "delete" -> Delete.create(lexer);
            default -> null;
        };
    }

    public static void show(List<Map<String,Object>> table) {
        SqlRow sqlRow = (SqlRow) table.get(0);
        for ( String key : sqlRow.keySet() ) {
            System.out.print( key + ", " );
        }
        System.out.println();
        for (Map<String, Object> stringObjectMap : table) {
            sqlRow = (SqlRow) stringObjectMap;
            for (String key : sqlRow.keySet()) {
                System.out.print(sqlRow.get(key) + ", ");
            }
            System.out.println();
        }
    }
}
