package org.cleancode.baseballgame.object;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<MatchResult> records = new ArrayList<>();

    public List<MatchResult> getRecords() {
        return records;
    }
    public void setRecords(List<MatchResult> records) {
        this.records = records;
    }

}
