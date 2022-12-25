package org.cleancode.baseballgame;

import org.cleancode.baseballgame.object.Balls;
import org.cleancode.baseballgame.object.Judge;
import org.cleancode.baseballgame.object.MatchResult;
import org.cleancode.baseballgame.view.Menu;
import org.cleancode.baseballgame.view.View;

import java.util.*;

public class BaseBallGame {
    private final View view = new View();
    private final Scanner sc = new Scanner(System.in);
    public String typeInput(){
        view.display(Menu.TYPE_INPUT);
        return sc.nextLine();
    }

    public BaseBallGame(){
        view.display(Menu.WELCOME);
        view.display(Menu.START_GAME);
        String answer = new Balls().getAnswer();
        boolean isGameWin = false;
        while (!isGameWin){
            isGameWin = playInning(answer);
        }
        view.display(Menu.END_GAME);
    }

    public boolean playInning(String answer){
        String input = typeInput();
        Optional<MatchResult> resultOptional = Judge.judge(input, answer);
        if(resultOptional.isEmpty()){ return false; }
        view.display(resultOptional.get());
        return resultOptional.get().isGameWin();
    }
}
