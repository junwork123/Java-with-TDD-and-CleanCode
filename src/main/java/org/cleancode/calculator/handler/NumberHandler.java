package org.cleancode.calculator.handler;

import java.util.regex.Pattern;

public class NumberHandler {
    private static final Pattern PATTERN = Pattern.compile("^[-+]?[0-9]+$");
    private NumberHandler(){}
    public static boolean supports(String item){
        return PATTERN.matcher(item).matches();
    }
}
