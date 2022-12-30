package org.cleancode.calculator.handlers;

import java.util.regex.Pattern;

public abstract class Handler<T> {
    protected final Pattern pattern;
    protected Handler(Pattern pattern){
        this.pattern = pattern;
    }
    public boolean supports(String item){
        return pattern.matcher(item).matches();
    }
    public abstract T parse(String item);
}
