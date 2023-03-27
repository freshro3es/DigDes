package com.digdes.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
    public void test1() {
        JavaSchoolStarter starter = new JavaSchoolStarter();

        Map<String,Object> map = new HashMap<>();
        map.put("id", Long.valueOf(3));
        map.put("lastName", "Федоров");
        map.put("age", Double.valueOf(40));
        map.put("active", true);
        List<Map<String,Object>> expected = List.of(map);

        List<Map<String,Object>> actual = null;
        try {
            //Вставка строки в коллекцию
            actual = starter.execute("  INSErT VALUES 'lastName' = 'Федоров' , 'id'=3, 'age'=40, 'active'=true  ");

        }catch (Exception ex){
            ex.printStackTrace();
            Assertions.fail("unexpected exception");
        }

        Assertions.assertEquals(expected, actual);
    }

}