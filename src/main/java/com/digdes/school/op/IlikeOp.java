package com.digdes.school.op;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//public class IlikeOp extends Op<String, String> {
//
//    @Override
//    public boolean apply(String left, String right) {
//        Pattern pattern = Pattern.compile(right.replace('%', '*'), Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(left);
//        return matcher.find();
//    }
//}


public class IlikeOp implements Op {

    @Override
    public boolean apply(Object left, Object right) {
        System.out.println(left);
        System.out.println(right);
        Pattern pattern = Pattern.compile(((String) right).replace("%", ".*"), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(((String) left));
        return matcher.find();
    }
}