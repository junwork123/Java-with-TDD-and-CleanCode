package org.cleancode.calculator.handlers;

import org.cleancode.calculator.calcuables.Number;

import java.util.regex.Pattern;

public class NumberHandler extends Handler<Number> {
    private NumberHandler(){ super(Pattern.compile("^[-+]?[0-9]+$")); }

    @Override
    public Number parse(String item) {
        if(!canHandle(item)){
            throw new IllegalArgumentException("Invalid input");
        }
        return new Number(Integer.parseInt(item));
    }
    private static final NumberHandler INSTANCE = new NumberHandler();
    public static boolean canHandle(String input){
        return INSTANCE.supports(input);
    }
    public static Number handle(String item) {
        return INSTANCE.parse(item);
    }
}
