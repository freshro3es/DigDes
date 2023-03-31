package com.digdes.school.op;

public class OpFactory {

    public static Op createOp(String cmd) {
        return switch (cmd) {
            case "!=" -> new NotEquityOp();
            case "=" -> new EquityOp();
            case "<" -> new LessOp();
            case "<=" -> new LessEquityOp();
            case ">" -> new GreaterOp();
            case ">=" -> new GreaterEquityOp();
            case "like" -> new LikeOp();
            case "ilike" -> new IlikeOp();
            case "or" -> new OrOp();
            case "and" -> new AndOp();
            default -> null;
        };
    }

}
