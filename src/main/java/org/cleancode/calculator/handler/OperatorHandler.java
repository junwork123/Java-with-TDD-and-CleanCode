package org.cleancode.calculator.handler;

import java.util.regex.Pattern;

public class OperatorHandler extends Handler {
    private OperatorHandler(){
        super(Pattern.compile("^[-+/*]$"));
    }
    private static final OperatorHandler INSTANCE = new OperatorHandler();
    public static boolean isSupports(String input){
        return INSTANCE.supports(input);
    }
}
