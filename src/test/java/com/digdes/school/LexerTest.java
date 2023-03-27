package com.digdes.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    @Test
    void readAll() {

        List<String> expected = Arrays.asList("SELECT", "WHERE", "'age'", ">=", "30", "and", "'lastName'", "ilike", "'%п%'");

        String cmd = "    SELECT  WHERE 'age'>=30 and 'lastName' ilike '%п%'    ";
        Lexer lexer = new Lexer(cmd);
        List<String> actual = null;
        try {
            actual = lexer.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("unexpected exception");
        }

        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(lexer.hasNext());
    }

    @Test
    void read() {
    }

    @Test
    void hasNext() {
    }
}