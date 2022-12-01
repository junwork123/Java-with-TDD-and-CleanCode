package org.cleancode.baseballgame.object;

import java.util.HashMap;
import java.util.Map;

public class Judge {
    public MatchResult judge(String input, String expected){
        int ball = 0, strike = 0;
        for (String item: input.split("")) {
            ball += isBall(item, expected);
            strike += isStrike(item, expected);
        }
        return new MatchResult(ball, strike);
    }

    private int isStrike(String item, String expected) {
        return 0;
    }

    private int isBall(String item, String expected) {
        return 0;
    }
}
