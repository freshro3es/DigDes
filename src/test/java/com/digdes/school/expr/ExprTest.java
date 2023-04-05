package com.digdes.school.expr;

import com.digdes.school.CreateTestTable;
import com.digdes.school.Lexer;
import com.digdes.school.op.IlikeOp;
import com.digdes.school.op.Op;
import com.digdes.school.sql.SqlRow;
import org.junit.jupiter.api.Test;

import java.util.List;

class ExprTest {

    @Test
    void createExpr() {
        Op op = new IlikeOp();
        try {
            op.apply("Петров", "%П%");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void evaluate() {
        String cmd = "'age'>=30 and 'lastName' ilike '%c%'";
        List<String> tokens;
        try {
            tokens = new Lexer(cmd).readAll();
            Expr expr = Expr.create(tokens);
            List<SqlRow> table = CreateTestTable.generate(8);
            for (SqlRow sqlRow : table) {
                System.out.println(expr.evaluate(sqlRow));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getTable() {

    }
}