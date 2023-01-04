package org.cleancode.calculator.pattern;

import org.cleancode.calculator.pattern.interfaces.RegexPattern;

import java.util.regex.Pattern;

public enum OperablePattern implements RegexPattern {
    ADD("[+]"),
    SUBTRACT("[-]"),
    MULTIPLY("[*]"),
    DIVIDE("[/]"),
    DISTANCE("(<->)");
    private final Pattern regex;

    OperablePattern(String regex) {
        this.regex = Pattern.compile(regex);
    }
    @Override
    public Pattern getPattern() {
        return regex;
    }
    @Override
    public String getRegex() { return regex.pattern(); }
}
