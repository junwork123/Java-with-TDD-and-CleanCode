package org.cleancode.calculator.handler;

import java.util.regex.Pattern;

public class NumberHandler extends Handler {
    private NumberHandler(){
        super(Pattern.compile("^[-+]?[0-9]+$"));
    }
    private static final NumberHandler INSTANCE = new NumberHandler();
    public static boolean isSupports(String input){
        return INSTANCE.supports(input);
    }
}
