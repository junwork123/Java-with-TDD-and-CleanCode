package org.cleancode.calculator.pattern;

import org.cleancode.calculator.pattern.interfaces.RegexPattern;

import java.util.regex.Pattern;

public enum CalculablePattern implements RegexPattern {
    NONE(""),
    NUMBER("[-+]?[0-9]+"),
    POINT("\\([-+]?\\d+,[-+]?\\d+\\)");
    private final Pattern regex;

    CalculablePattern(String regex) {
        this.regex = Pattern.compile(regex);
    }
    @Override
    public Pattern getPattern() {
        return regex;
    }
    @Override
    public String getRegex() { return regex.pattern(); }
}
