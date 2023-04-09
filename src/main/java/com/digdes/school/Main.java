package com.digdes.school;

import java.util.Scanner;

public class Main {

    public static void main(String... args){
        JavaSchoolStarter starter = new JavaSchoolStarter();
        String cmd = null;
        while (!"exit".equals(cmd)) {
            Scanner in = new Scanner(System.in);
            //System.out.print("Input a command: ");
            cmd = in.nextLine();
            try {
                JavaSchoolStarter.show(starter.execute(cmd));
            } catch (Exception e) {
                System.err.println(e.getMessage());
                //throw new RuntimeException(e);
            }
        }
    }
}

//insert values 'id'=4, 'lastName'='Качаев', 'age'=0, 'cost'=100.0, 'active'=false
//insert values 'id' = 8 , 'lastName' = 'Минуллин' , 'age' = 23 , 'cost' = 50.0 , 'active' = true
//insert values 'id'=6, 'lastName'='Корзинина', 'age'=17, 'cost'=23.0, 'active'=false
//insert values 'id'=10, 'lastName'='Абрамов', 'age'=40, 'cost'=150.0, 'active'=true
//update values 'active'=false
//update values 'age'=null where 'lastName'='Качаев'
//select where 'age'!=23