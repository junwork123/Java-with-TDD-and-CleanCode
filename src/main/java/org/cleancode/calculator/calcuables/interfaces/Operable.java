package org.cleancode.calculator.calcuables.interfaces;

import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.pattern.OperablePattern;

import java.util.List;
import java.util.regex.Pattern;

public interface Operable {
    CalculablePattern getTarget();

    OperablePattern getSymbol();
    int getHowMany();
    String apply(List<String> items);
    static boolean isMatch(Operable op, String input){
        input = input.replaceAll(" ", ""); // 공백제거
        return getPattern(op).matcher(input).matches();
    }
    static Pattern getPattern(Operable op){
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
        return "(" + input + ")";
    }
}
