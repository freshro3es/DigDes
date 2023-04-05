package com.digdes.school.sql;

import com.digdes.school.JavaSchoolStarter;
import com.digdes.school.Lexer;
import com.digdes.school.assignment.Ass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SqlRowTest {

    @Test
    void sqlRow() {
        SqlRow sqlRow = new SqlRow();
        sqlRow.put("age", 3);
        for (String key : sqlRow.keySet()) {
            System.out.println(key);
        }
    }

//    @Test
//    void sqlRow() {
//        Map<String, Object> sqlRow = new HashMap<>();
//        sqlRow.put("id", null);
//        sqlRow.put("lastname", null);
//
//        for (String key : sqlRow.keySet()) {
//            System.out.println(key);
//        }
//    }

    @Test
    void put() {
        SqlRow sqlRow = new SqlRow();
        sqlRow.put("age", 3);
        JavaSchoolStarter.show(List.of(sqlRow));
    }

    @Test
    void testPut() {
        String cmd = "    'age'=30, 'lastName'='п'    ";
        Lexer lexer = new Lexer(cmd);
        List<String> actual = null;
        try {
            actual = lexer.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("unexpected exception");
        }

        JavaSchoolStarter.show(List.of(Ass.createAss(actual).evaluate(new SqlRow())));
    }
}