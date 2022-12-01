package org.cleancode.baseballgame.object;

import java.util.List;

public class Player {
    private List<MatchResult> records;

    public List<MatchResult> getRecords() {
        return records;
    }
    public void setRecords(List<MatchResult> records) {
        this.records = records;
    }
    public enum MatchResult{
        WIN,
        LOOSE
    }
}
