package org.cleancode.calculator.handlers;

import org.cleancode.calculator.calcuables.Operator;

import java.util.regex.Pattern;

public class OperatorHandler extends Handler<Operator> {
    private OperatorHandler(){ super(Pattern.compile("^[-+/*]$")); }

    @Override
    public Operator parse(String item) {
        if(!canHandle(item)){
            throw new IllegalArgumentException("Invalid input");
        }
        return Operator.of(item);
    }
    private static final OperatorHandler INSTANCE = new OperatorHandler();
    public static boolean canHandle(String input){
        return INSTANCE.supports(input);
    }
    public static Operator handle(String item) {
        return INSTANCE.parse(item);
    }
}
