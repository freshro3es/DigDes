package com.digdes.school.op;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//public class LikeOp extends Op<String, String> {
//
//    @Override
//    public boolean apply(String left, String right) {
//        Pattern pattern = Pattern.compile(right.replace('%', '*'));
//        Matcher matcher = pattern.matcher(left);
//        return matcher.find();
//    }
//}

public class LikeOp implements Op {

    @Override
    public boolean apply(Object left, Object right) {
        try {
            Pattern pattern = Pattern.compile(((String) right).replace("%", ".*"));
            Matcher matcher = pattern.matcher(((String) left));
            return matcher.find();
        } catch (Exception ex) {
            throw new ClassCastException("Invalid type in Like Operation");
        }
    }
}
