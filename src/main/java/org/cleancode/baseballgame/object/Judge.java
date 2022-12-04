package org.cleancode.baseballgame.object;

import java.util.Arrays;
import java.util.Optional;

public class Judge {
    public static final int LENGTH_OF_BALLS = 3;
    private Judge(){}

    public static Optional<MatchResult> judge(String input, String expected){
        if(validate(input)) {
            return Optional.of(new MatchResult(countBalls(input, expected), countStrikes(input, expected)));
        }
        return Optional.empty();
    }

    public static int countStrikes(String input, String expected) {
        return (int) Arrays.stream(input.split(""))
                .filter(expected::contains)
                .filter(charAt -> input.indexOf(charAt) == expected.indexOf(charAt))
                .count();
    }

    public static int countBalls(String input, String expected) {
        return (int) Arrays.stream(input.split(""))
                .filter(expected::contains)
                .filter(charAt -> input.indexOf(charAt) != expected.indexOf(charAt))
                .count();
    }

    public static boolean validate(String input){
        return isValidLength(input) &&
                isValidNumberFormat(input);
    }
    public static boolean isValidLength(String input){
        return input.length() == LENGTH_OF_BALLS;
    }
    public static boolean isValidNumberFormat(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new NumberFormatException();
        }
        return true;
    }
}
