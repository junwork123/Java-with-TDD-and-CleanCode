package org.cleancode.baseballgame;

import java.util.Arrays;

public class ResultView implements View {

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
