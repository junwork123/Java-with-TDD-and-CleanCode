package org.cleancode.baseballgame.view;

import org.cleancode.baseballgame.object.MatchResult;

import java.util.Arrays;

public class ResultView implements View {
    public void display(MatchResult result){
        if(result.isWin()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        System.out.printf("%d 볼", result.getBalls());
        System.out.printf("%d 스트라이크", result.getStrikes());
    }

    @Override
    public void display(Menu menu) {
        Arrays.stream(InnerMenu.values())
                .filter(innerMenu -> innerMenu.menu.equals(menu))
                .findFirst()
                .ifPresent(innerMenu -> System.out.println(innerMenu.msg));
    }
    enum InnerMenu{
        INNING_RESULT(Menu.INNING_RESULT, "이닝 점수를 발표합니다"),
        GAME_RESULT(Menu.GAME_RESULT,"게임 결과를 발표합니다.");

        private final String msg;
        private final Menu menu;
        InnerMenu(Menu menu, String msg){
            this.menu = menu;
            this.msg = msg;
        }
    }
}
