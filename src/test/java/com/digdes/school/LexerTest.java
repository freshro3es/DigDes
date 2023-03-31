package com.digdes.school;

import com.digdes.school.term.*;
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

    @Test
    void validParseLong() {
        Term<Long> expected = new LongTerm(40L);

        String token = "40";
        Term<Long> actual = TermFactory.createLongTerm(token);

        assert actual != null;
        Assertions.assertEquals(expected.getValue(null), actual.getValue(null));
    }

    @Test
    void invalidParseLong() {
        String token = "adfg40sldfj";
        Term<Long> actual = TermFactory.createLongTerm(token);

        assert actual == null;
    }

    @Test
    void validParseDouble() {
        Term<Double> expected = new DoubleTerm(40.0);

        String token = "40.0";
        Term<Double> actual = TermFactory.createDoubleTerm(token);

        assert actual != null;
        Assertions.assertEquals(expected.getValue(null), actual.getValue(null));
    }

    @Test
    void invalidParseDouble() {
        String token = "adfg40.0sldfj";
        Term<Double> actual = TermFactory.createDoubleTerm(token);

        assert actual == null;
    }

    @Test
    void validParseString() {
        Term<String> expected = new StringTerm("value");

        String token = "'value'";
        Term<String> actual = TermFactory.createStringTerm(token);

        assert actual != null;
        Assertions.assertEquals(expected.getValue(null), actual.getValue(null));
    }

    @Test
    void validParseEmptyString() {
        Term<String> expected = new StringTerm("");

        String token = "''";
        Term<String> actual = TermFactory.createStringTerm(token);

        assert actual != null;
        Assertions.assertEquals(expected.getValue(null), actual.getValue(null));
    }

    @Test
    void invalidParseString() {

        String token = "value";
        Term<String> actual = TermFactory.createStringTerm(token);

        assert actual == null;
    }
}