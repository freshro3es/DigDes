package com.digdes.school.expr;

import com.digdes.school.Lexer;
import com.digdes.school.op.Op;
import com.digdes.school.term.Term;
import com.digdes.school.term.TermFactory;
import com.digdes.school.op.OpFactory;

import java.util.List;



public class Where {

    public static Where create(String cmd) {
        Lexer lexer = new Lexer(cmd);
        List<String> tokens;
        try {
            tokens = lexer.readAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        if ((tokens.size()<3) || ((tokens.size()-3)%4!=0)) {
//            throw new RuntimeException();
//        }
//
//        Term<?> left = TermFactory.createTerm(tokens.remove(0));
//        Op<Object, Object> op = createOp(tokens.remove(0));
//        Term<?> right = TermFactory.createTerm(tokens.remove(0));
//        System.out.println(op.apply(left.getValue(), right.getValue()));



        return null;
    }
}
