package com.digdes.school;

import com.digdes.school.sql.SqlRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MainTest {

    @Test
    public void splitString() {

        List<String> expected = new ArrayList<>();
        expected.add("aaa");
        expected.add("bbb");
        expected.add("ccc");

        List<String> actual = List.of("aaa bbb ccc".split(" "));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testInsertValidValues() {
        JavaSchoolStarter starter = new JavaSchoolStarter();

        SqlRow map = new SqlRow();
        map.put("id", 3L);
        map.put("lastname", "Федоров");
        map.put("age", 40L);
        map.put("active", true);
        map.put("cost", 1.0);
        List<Map<String,Object>> expected = List.of(map);


        List<Map<String,Object>> actual = null;
        try {
            //Вставка строки в коллекцию
            actual = starter.execute("  INSErT VALUES 'lastName' = 'Федоров' , 'id'=3, 'age'=40, 'active'=true, 'cost'=1.0  ");

        }catch (Exception ex){
            ex.printStackTrace();
            Assertions.fail("unexpected exception");
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEmptyInsert() {
        JavaSchoolStarter starter = new JavaSchoolStarter();

        String token = "";
        Exception expected = new IllegalArgumentException("Command expected, empty line token");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }
    }


    @Test
    public void testInvalidCommandInsert() {
        JavaSchoolStarter starter = new JavaSchoolStarter();

        String token = "selact";
        Exception expected = new IllegalArgumentException("Command \"" + token + "\" does not exist");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }
    }

    @Test
    public void testInvalidSecondaryCommandInsert() {
        JavaSchoolStarter starter = new JavaSchoolStarter();
        Exception expected;
        String token;

        token = "select whore";
        expected = new IllegalArgumentException("Select command token, but not where");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "insert valle";
        expected = new IllegalArgumentException("Insert token, values is not");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "update valle";
        expected = new IllegalArgumentException("Update command token, but not values");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "delete whore";
        expected = new IllegalArgumentException("Delete command token, but not where");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "update values";
        expected = new IllegalArgumentException("Values to change expected, nothing token");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "update values where";
        expected = new IllegalArgumentException("Values to change expected, nothing token");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "update values whore";
        expected = new IllegalArgumentException("Invalid expression in values statement");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "update values 'id'=3";
        expected = new IllegalArgumentException("Update command token, but table is empty");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "update";
        expected = new IllegalArgumentException("Update command token, but not values");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "insert";
        expected = new IllegalArgumentException("Insert token, values is not");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "select where mom";
        expected = new IllegalArgumentException("Invalid expression in where statement");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "select where danila is crasy";
        expected = new IllegalArgumentException("Unexpected op token: is");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "select where";
        expected = new IllegalArgumentException("Where command token, but nothing after");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "delete where";
        expected = new IllegalArgumentException("Where command token, but nothing after");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "insert values 'id'=3 'lastname'=5";
        expected = new IllegalArgumentException("Invalid expression in values statement: \",\" expected");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }

        token = "select where ('id'=3 or 'lastname'='Федор' and 'cost'=1.0)) and 'age'<10";
        expected = new IllegalArgumentException("An unequal number of brackets was accepted");

        try {
            starter.execute(token);
        } catch (Exception actual) {
            Assertions.assertEquals(expected.getMessage(), actual.getMessage());
        }
    }
}