package com.digdes.school;

import com.digdes.school.sql.SqlRow;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import static java.lang.Math.round;

public class CreateTestTable {



    public static List<SqlRow> generate(int capacity) {
        List<SqlRow> sqlRows = new ArrayList<>();
        Random random = new Random();

        for (int i=0; i<capacity; i++) {
            SqlRow sqlRow = new SqlRow();
            sqlRow.put("id", random.nextLong(1, 100));
            sqlRow.put("lastname", generateString());
            sqlRow.put("age", random.nextLong(15, 50));
            sqlRow.put("cost", Double.valueOf(round(random.nextDouble(0.0, 50.0)*10))/10);
            sqlRow.put("active", random.nextBoolean());
            sqlRows.add(sqlRow);
        }
        return sqlRows;
    }

    public static void show(List<SqlRow> sqlRows) {
        SqlRow sqlRow = sqlRows.get(0);
        for ( String key : sqlRow.keySet() ) {
            System.out.print( key + ", " );
        }
        System.out.println();

        for (int i=0; i<sqlRows.size(); i++) {
            sqlRow = sqlRows.get(i);
            for ( String key : sqlRow.keySet() ) {
                System.out.print( sqlRow.get(key) + ", " );
            }
            System.out.println();
        }
    }

    public static String generateString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

}
