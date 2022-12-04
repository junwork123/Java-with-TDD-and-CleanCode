package org.cleancode.baseballgame.view;

import org.cleancode.baseballgame.object.MatchResult;

public class View{
    public void display(MatchResult result){
        if(result.isWin()){
            display(Menu.CORRECT_ANSWER);
            return;
        }
        System.out.printf("%d볼 ", result.getBalls());
        System.out.printf("%d스트라이크 \n", result.getStrikes());
    }
    public void display(Menu menu) {
        System.out.println(menu.getMsg());
    }

}
