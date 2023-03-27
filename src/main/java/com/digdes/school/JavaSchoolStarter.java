package com.digdes.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaSchoolStarter {

    private List<Map<String,Object>> table = new ArrayList<>();

    //Дефолтный конструктор
    public JavaSchoolStarter(){

    }

    private void select(String request) {
        System.out.println("Entered in SELECT");
        if ("*".equals(request) & !table.isEmpty()) {
            System.out.println("id, lastName, age, active");
            for (int i=0; i<table.size(); i++) {
                System.out.println(table.get(i).get("id") + ", " +
                                   table.get(i).get("lastName") + ", " +
                                   table.get(i).get("age") + ", " +
                                   table.get(i).get("active"));
            }
        }
    }

    private void update(String request) {
        System.out.println("Entered in UPDATE");

    }

    private void insert(String request) {
        System.out.println("Entered in INSERT");
        Map<String,Object> result = this.values(request);
        if (result.isEmpty()) return;
        if (!result.containsKey("id")) result.put("id", null);
        if (!result.containsKey("lastName")) result.put("lastName", null);
        if (!result.containsKey("age")) result.put("age", null);
        if (!result.containsKey("active")) result.put("active", null);
        table.add(result);
    }

    private void delete(String request) {
        System.out.println("Entered in DELETE");


    }

    private Map<String, Object> values(String request) {
        System.out.println("Entered in VALUES");
        String statement = request.trim().substring(0,6);
        request = request.replace(statement, "").trim();
        System.out.println(request);
        return this.getMap(request);
    }

    private void where(String request) {
        System.out.println("Entered in WHERE");
        String statement = request.trim().substring(0,5);
        request = request.replace(statement, "").trim();
        System.out.println(request);
        int start, end, mid;
        if (request.contains("(")) {
            start = request.lastIndexOf("(");
            if (request.contains("(")) {
                end = request.indexOf(")", start);
            } else {
                System.err.println("Отсутствует скобка \")\"!");
            }
        }



//        return this.getMap(request);
    }

    private Map<String,Object> getMap(String request) {
        Map<String, Object> result = new HashMap<>();
        String key, value;

        String[] map = request.split(",");
        for (int i=0; i<=map.length-1; i++) {
            System.out.println("Выражение: " + map[i].trim());
            key = map[i].trim().substring(0, map[i].trim().indexOf("=")).replace("'", "").trim();
            System.out.println("Key: " + key);
            switch (key) {
                case ("id"):
                    try {
                        Long longValue = Long.valueOf(map[i].trim().substring(map[i].trim().indexOf("=")+1));
                        System.out.println("Value: " + longValue);
                        result.put(key, longValue);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                case ("lastName"):
                    try {
                        value = map[i].trim().substring(map[i].trim().indexOf("=")+1).replace("'", "").trim();
                        System.out.println("Value: " + value);
                        result.put(key, value);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                case ("age"):
                    try {
                        Double doubleValue = Double.valueOf(map[i].trim().substring(map[i].trim().indexOf("=")+1));
                        System.out.println("Value: " + doubleValue);
                        result.put(key, doubleValue);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                case ("active"):
                    try {
                        Boolean boolValue = Boolean.valueOf(map[i].trim().substring(map[i].trim().indexOf("=")+1));
                        System.out.println("Value: " + boolValue);
                        result.put(key, boolValue);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                default:
                    System.err.println("Column " + key + " doesn't exist!");
                    break;
            }

        }

        return result;
    }

    //На вход запрос, на выход результат выполнения запроса
    public List<Map<String,Object>> execute(String request) throws Exception {
        //Здесь начало исполнения вашего кода

//        request.trim();
        String statement = request.trim().substring(0,6);
        request = request.replace(statement, "").trim();
        statement = statement.toUpperCase();
        System.out.println("Запрос: " + statement);

        switch (statement) {
            case ("SELECT"):
                this.select(request);
                break;
            case ("INSERT"):
                this.insert(request);
                break;
            case ("UPDATE"):
                this.update(request);
                break;
            case ("DELETE"):
                this.delete(request);
                break;
        }
        System.out.println("--------------------------------------------------");
        return table;
    }
}
