package com.digdes.school.op;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LikeOp implements Op {
    @Override
    public boolean apply(Object left, Object right) throws Exception {
        Pattern pattern = Pattern.compile(((String) right).replace("%", ".*"));
        Matcher matcher = pattern.matcher(((String) left));
        return matcher.find();
    }
}
