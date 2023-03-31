package com.digdes.school.term;

public class TermFactory {

    public static Term<Boolean> createBoolTerm(String token) {
        token.toLowerCase();
        return "true".equals(token) ? new BoolTerm(true) : "false".equals(token) ? new BoolTerm(false) : null;
    }

    public static Term<Long> createLongTerm(String token) {
        try {
            return new LongTerm(Long.parseLong(token));
        } catch (NumberFormatException ex) {
            System.err.println("Token is not a Long");
        }
        return null;
    }

    public static Term<Double> createDoubleTerm(String token) {
        try {
            return new DoubleTerm(Double.parseDouble(token));
        } catch (NumberFormatException ex) {
            System.err.println("Token is not a Double");
        }
        return null;
    }

    public static Term<String> createStringTerm(String token) {
        if (token.indexOf("'")!=0) {
            return null;
        }
        if (token.lastIndexOf("'")!=token.length()-1) {
            return null;
        }
        return new StringTerm(token.substring(1, token.length()-1));
    }

    public static RefTerm createRefTerm(String token) {
        if (token.indexOf("'")!=0) {
            return null;
        }
        if (token.lastIndexOf("'")!=token.length()-1) {
            return null;
        }
        return new RefTerm(token.substring(1, token.length()-1).toLowerCase());
    }

    public static Term<? extends Object> createTerm(String token) {

        Term<Boolean> boolTerm = createBoolTerm(token);
        if (boolTerm!=null) {
            return boolTerm;
        }

        Term<Long> longTerm = createLongTerm(token);
        if (longTerm!=null) {
            return longTerm;
        }

        Term<Double> doubleTerm = createDoubleTerm(token);
        if (doubleTerm!=null) {
            return doubleTerm;
        }

        Term<String> stringTerm = createStringTerm(token);
        if (stringTerm!=null) {
            return stringTerm;
        }

        return null;
    }


}
