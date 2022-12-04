package org.cleancode.baseballgame.object;

public class MatchResult {
    private final int balls;
    private final int strikes;

    public MatchResult(int balls, int strikes){
        this.balls = balls;
        this.strikes = strikes;
    }
    public int getBalls() {
        return balls;
    }
    public int getStrikes() {
        return strikes;
    }

    public boolean isWin(){
        return strikes == 3 && balls == 0;
    }
}
