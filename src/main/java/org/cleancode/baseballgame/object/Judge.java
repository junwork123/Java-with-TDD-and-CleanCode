package org.cleancode.baseballgame.object;

import java.util.Arrays;

public class Judge {
    private Judge(){}

    public static MatchResult judge(String input, String expected){
        return new MatchResult(isBall(input, expected), isStrike(input, expected));
    }

    public static int isStrike(String input, String expected) {
        return (int) Arrays.stream(input.split(""))
                .filter(expected::contains)
                .filter(charAt -> input.indexOf(charAt) == expected.indexOf(charAt))
                .count();
    }

    public static int isBall(String input, String expected) {
        return (int) Arrays.stream(input.split(""))
                .filter(expected::contains)
                .filter(charAt -> input.indexOf(charAt) != expected.indexOf(charAt))
                .count();
    }
}
