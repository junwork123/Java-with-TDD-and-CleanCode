package org.cleancode.baseballgame.view;

import java.util.Arrays;

public class InputView implements View {

    @Override
    public void display(Menu menu) {
        Arrays.stream(InnerMenu.values())
                .filter(innerMenu -> innerMenu.menu.equals(menu))
                .findFirst()
                .ifPresent(innerMenu -> {
                    System.out.println(innerMenu.msg);
                });
    }

    public enum InnerMenu{
        START_GAME(Menu.START_GAME, "숫자 야구 게임을 시작하시겠습니까?"),
        END_GAME(Menu.END_GAME, "게임을 종료하시겠습니까?"),
        START_INNING(Menu.START_INNING, "3자리 숫자를 입력해주세요");

        private final String msg;
        private final Menu menu;
        InnerMenu(Menu menu, String msg){
            this.menu = menu;
            this.msg = msg;
        }
    }
}
