package com.digdes.school;

import java.util.Scanner;

public class Main {

    public static void main(String... args){
        JavaSchoolStarter starter = new JavaSchoolStarter();
//      //Изменение значения которое выше записывали
//      List<Map<String,Object>> result2 = starter.execute("    UpDaTE VALUES 'active'=false, 'cost'=10.1 where 'id'=3  ");
//      //Получение всех данных из коллекции (т.е. в данном примере вернется 1 запись)
//      List<Map<String,Object>> result3 = starter.execute(" SELeCT *  ");
//      CreateTestTable.show(starter.execute("    Insert VALUES 'id'=3, 'lastName'='Федор', 'cost'=1.0  "));
//      CreateTestTable.show(starter.execute("    UpDaTE VALUES 'active'=false, 'cost'=10.1 where 'id'=3  "));
        //insert vaLuEs 'id'=4 'lastName'='Афанасьев', 'cost'=5.5, 'age'=16, 'active'=false
        String cmd = null;
        while (!"exit".equals(cmd)) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a command: ");
            cmd = in.nextLine();
            try {
                JavaSchoolStarter.show(starter.execute(cmd));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
