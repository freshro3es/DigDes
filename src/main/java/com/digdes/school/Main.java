package com.digdes.school;


import java.util.List;
import java.util.Map;





public class Main {

    public static void main(String... args){
        JavaSchoolStarter starter = new JavaSchoolStarter();
        try {
            //Изменение значения которое выше записывали
            List<Map<String,Object>> result2 = starter.execute("    UpDaTE VALUES 'active'=false, 'cost'=10.1 where 'id'=3  ");
            //Получение всех данных из коллекции (т.е. в данном примере вернется 1 запись)
            List<Map<String,Object>> result3 = starter.execute(" SELeCT *  ");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
