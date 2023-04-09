package com.digdes.school;

import com.digdes.school.sql.SqlRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            sqlRow.put("cost", (double) round(random.nextDouble(0.0, 50.0) * 10) /10);
            sqlRow.put("active", random.nextBoolean());
            sqlRows.add(sqlRow);
        }
        return sqlRows;
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

        return buffer.toString();
    }
}
