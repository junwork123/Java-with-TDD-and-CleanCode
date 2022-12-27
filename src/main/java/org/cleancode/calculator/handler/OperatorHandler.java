package org.cleancode.calculator.handler;

import java.util.regex.Pattern;

public class OperatorHandler {
    private static final Pattern PATTERN = Pattern.compile("^[-+/*]{1}$");
    private OperatorHandler(){}
    public static boolean supports(String item){
        return PATTERN.matcher(item).matches();
    }
}
