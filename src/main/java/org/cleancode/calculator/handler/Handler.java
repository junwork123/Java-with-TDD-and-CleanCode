package org.cleancode.calculator.handler;

import java.util.regex.Pattern;

public class Handler {
    protected final Pattern pattern;
    protected Handler(Pattern pattern){
        this.pattern = pattern;
    }
    public boolean supports(String item){
        return pattern.matcher(item).matches();
    }
}
