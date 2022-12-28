package org.cleancode.calculator.handler;

import java.util.regex.Pattern;

public class PointHandler extends Handler {
    private PointHandler(){
        super(Pattern.compile("^\\([-+]?\\d+,[-+]?\\d+\\)$"));
    }
    private static final PointHandler INSTANCE = new PointHandler();
    public static boolean isSupports(String input){
        return INSTANCE.supports(input);
    }
}
