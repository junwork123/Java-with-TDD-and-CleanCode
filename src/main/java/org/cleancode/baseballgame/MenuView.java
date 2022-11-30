package org.cleancode.baseballgame;

import java.util.Arrays;

public class MenuView implements View{
    public void display(Menu menu) {
        Arrays.stream(InnerMenu.values())
                .filter(innerMenu -> innerMenu.menu.equals(menu))
                .findFirst()
                .ifPresent(innerMenu -> System.out.println(innerMenu.msg));
    }
    public enum InnerMenu{
        WELCOME(Menu.WELCOME, "안녕하세요! 숫자 야구 게임에 오신 것을 환영합니다."),
        START_GAME(Menu.START_GAME,"숫자 야구 게임을 시작합니다."),
        END_GAME(Menu.END_GAME, "게임을 종료합니다"),
        START_INNING(Menu.START_INNING, "이닝을 시작합니다"),
        END_INNING(Menu.END_INNING, "이닝을 종료합니다");

        private final String msg;
        private final Menu menu;
        InnerMenu(Menu menu, String msg){
            this.menu = menu;
            this.msg = msg;
        }
    }
}
