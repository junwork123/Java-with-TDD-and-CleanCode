package org.cleancode.calculator.calcuables.interfaces;

import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.pattern.OperablePattern;

import java.util.regex.Pattern;

public interface Operable<T> {
    T apply(T a, T b);
    CalculablePattern getTarget();
    OperablePattern getSymbol();
    int getHowMany();
    static boolean isMatch(Operable op, String input){
        input = input.replaceAll(" ", ""); // 공백제거
        return getPattern(op).matcher(input).matches();
    }
    private static Pattern getPattern(Operable op){
        String target = wrap(op.getTarget().getRegex());
        int howMany = op.getHowMany();
        String symbol = wrap(op.getSymbol().getRegex());
        StringBuilder result = new StringBuilder(target);
        for (int i = 1; i < howMany; i++) {
            result.append(symbol).append(target);
        }
        return Pattern.compile("^" + result + "$");
    }
    private static String wrap(String input){
        input = input.replaceAll("[\\^$]", ""); // 정규식 양끝문자 제거
        return "(" + input + ")";
    }
}
