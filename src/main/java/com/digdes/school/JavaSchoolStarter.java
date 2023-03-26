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
    }

    private void update(String request) {
        System.out.println("Entered in UPDATE");

    }

    private void insert(String request) {
        System.out.println("Entered in INSERT");
        Map<String,Object> result = this.values(request);
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

    private Map<String, Object> where(String request) {
        System.out.println("Entered in WHERE");
        String statement = request.trim().substring(0,5);
        request = request.replace(statement, "").trim();
        System.out.println(request);
        return this.getMap(request);
    }

    private Map<String,Object> getMap(String request) {
        Map<String, Object> result = new HashMap<>();
        String key, value;

        String[] map = request.split(",");
        for (int i=0; i<=map.length-1; i++) {
            System.out.println(map[i].trim());
            key = map[i].trim().substring(0, map[i].trim().indexOf("=")).replace("'", "").trim();
            System.out.println(key);
            switch (key) {
                case ("id"):
                    try {
                        Long longValue = Long.valueOf(map[i].trim().substring(map[i].trim().indexOf("=")+1));
                        System.out.println(longValue);
                        result.put(key, longValue);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                case ("lastName"):
                    value = map[i].trim().substring(map[i].trim().indexOf("=")+1);
                    System.out.println(value);
                    break;
                case ("age"):
                    try {
                        Double doubleValue = Double.valueOf(map[i].trim().substring(map[i].trim().indexOf("=")+1));
                        System.out.println(doubleValue);
                        result.put(key, doubleValue);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                case ("active"):
                    try {
                        Boolean boolValue = Boolean.valueOf(map[i].trim().substring(map[i].trim().indexOf("=")+1));
                        System.out.println(boolValue);
                        result.put(key, boolValue);
                    }catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки для столбца " + key + "!");
                    }
                    break;
                default:
                    System.err.println("Столбца " + key + " нет!");
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
        System.out.println(statement);
        System.out.println(request);

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
