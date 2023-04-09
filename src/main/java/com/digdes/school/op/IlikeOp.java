package com.digdes.school.op;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IlikeOp implements Op {
    @Override
    public boolean apply(Object left, Object right) throws Exception {
        if (left!=null) {
            Pattern pattern = Pattern.compile(((String) right).replace("%", ".*"), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(((String) left));
            return matcher.find();
        } else {
            return false;
        }
    }
}