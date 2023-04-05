package com.digdes.school.expr;

import com.digdes.school.JavaSchoolStarter;
import com.digdes.school.Lexer;
import com.digdes.school.assignment.Ass;
import com.digdes.school.sql.SqlRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AssTest {

    @Test
    void createAss() {
    }

    @Test
    void evaluate() {
        String cmd = "    'age'=30, 'lastName'='п'    ";
        Lexer lexer = new Lexer(cmd);
        List<String> actual = null;
        try {
            actual = lexer.readAll();
            System.out.println(actual);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("unexpected exception");
        }

        JavaSchoolStarter.show(List.of(Ass.createAss(actual).evaluate(new SqlRow())));
    }
}