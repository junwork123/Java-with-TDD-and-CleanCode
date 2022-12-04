package org.cleancode.baseballgame.view;

import org.cleancode.baseballgame.object.MatchResult;

public class View{
    public void display(MatchResult result){
        if(result.isWin()){
            display(Menu.CORRECT_ANSWER);
            return;
        }
        if(result.getBalls() == 0 && result.getStrikes() > 0){
            System.out.println("4볼");
            return;
        }
        if(result.getBalls() > 0){
            System.out.printf("%d볼 ", result.getBalls());
        }
        if(result.getStrikes() > 0){
            System.out.printf("%d스트라이크", result.getStrikes());
        }
        System.out.println();
    }
    public void display(Menu menu) {
        System.out.println(menu.getMsg());
    }

}
