package com.digdes.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {

    private final String cmd;
    private int pos;

    public Lexer(String cmd) {
        this.cmd = cmd;
        this.pos = 0;
        skipSpaces();
    }

    public static Lexer create(String cmd) {
        if (0==cmd.length()) {
            throw new IllegalArgumentException("Command expected, empty line token");
        }
        return new Lexer(cmd);
    }

    public List<String> readAll() throws Exception {
        if (!checkBrackets()) {
            throw new IllegalArgumentException("An unequal number of brackets was accepted");
        }

        List<String> tokens = new ArrayList<>();
        while (hasNext()) {
           tokens.add(read());
        }
        System.out.println(tokens);
        return tokens;
    }

    public String read() throws Exception {
        int start = pos;
        switch (readChar()) {
            case '\'':
                int index = cmd.indexOf('\'', pos);
                if (index < 0) {
                    throw new Exception("symbol ' not found");
                }
                pos = index+1;
                break;
            case '=':
                break;
            case '<', '>':
                if (pos<cmd.length() && readChar()!='=') {
                    pos--;
                }
                break;
            case '!':
                if (pos==cmd.length() || readChar()!='=') {
                    throw new Exception("= expected after !");
                }
                break;
            default:
                pos = nextDelimiter();
        }
        String token = cmd.substring(start, pos);
        skipSpaces();
        return token;
    }

    public boolean isNext(String token) throws Exception {
        int start = pos;
        try {
            return token.equalsIgnoreCase(read());
        } finally {
            pos = start;
        }
    }

    public boolean hasNext() {
        return pos!=cmd.length();
    }

    private void skipSpaces() {
        while (pos<cmd.length() && cmd.charAt(pos)==' ') {
            pos++;
        }
    }

    private char readChar() {
        return cmd.charAt(pos++);
    }

    private int nextDelimiter() {
        Matcher m = Pattern.compile("[<>=! ',()]").matcher(cmd);
        if(m.find(pos)) {
            return m.start();
        }
        return cmd.length();
    }

    private boolean checkBrackets() throws Exception {
        int start = pos;
        Map<String, Integer> brackets = new HashMap<>(Map.of("(", 0, ")", 0));
        while (hasNext()) {
            String token = read();
            if ("(".equals(token) || ")".equals(token)) {
                brackets.put(token, brackets.get(token)+1);
            }
        }
        pos = start;
        return brackets.get("(").equals(brackets.get(")"));
    }
}