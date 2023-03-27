package com.digdes.school;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {

    private String cmd;
    private int pos;

    public Lexer(String cmd) {
        this.cmd = cmd;
        this.pos = 0;
        skipSpaces();
    }

    public List<String> readAll() throws Exception {
        List<String> tokens = new ArrayList<>();

        while (hasNext()) {
           tokens.add(read());
        }
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
                pos = nextDelimeter();
                System.out.println(pos);
        }


        String token = cmd.substring(start, pos);
        skipSpaces();
        return token;
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

    private int nextDelimeter() {
        Matcher m = Pattern.compile("[<>=! ']").matcher(cmd);
        if(m.find(pos)) {
            return m.start();
        }
        return cmd.length();
    }

}
