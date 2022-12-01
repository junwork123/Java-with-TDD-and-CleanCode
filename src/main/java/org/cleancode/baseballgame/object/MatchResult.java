package org.cleancode.baseballgame.object;

public class MatchResult {
    private final int ball;
    private final int strike;

    public MatchResult(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }
    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }

}
