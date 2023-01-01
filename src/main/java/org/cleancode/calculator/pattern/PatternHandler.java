package org.cleancode.calculator.pattern;

import org.cleancode.calculator.pattern.interfaces.HandleFor;

import java.util.regex.Pattern;

public class PatternHandler {
    public static boolean supports(Class<?> aClass, String item){
        return getPattern(aClass).matcher(item).matches();
    }
    public static Pattern getPattern(Class<?> aClass){
        return aClass.getAnnotation(HandleFor.class).target().getPattern();
    }
}
