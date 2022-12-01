package org.cleancode.baseballgame.object;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Judge {
    public Map<String, Integer> judge(String input, String expected){
        Map<String, Integer> result = new HashMap<>();

        int ball = 0, strike = 0;
        for (String item: input.split("")) {
            ball += isBall(item, expected);
            strike += isStrike(item, expected);
        }

        result.put("ball", ball);
        result.put("strike", strike);
        return result;
    }

    private int isStrike(String item, String expected) {
        return 0;
    }

    private int isBall(String item, String expected) {
        return 0;
    }
}
