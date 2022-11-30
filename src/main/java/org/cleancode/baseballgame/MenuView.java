package org.cleancode.baseballgame;

public class MenuView implements View{
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private Menu menu;

    @Override
    public void display() {
        System.out.println(menu.msg);
    }
    public enum Menu{
        WELCOME("안녕하세요! 숫자 야구 게임에 오신 것을 환영합니다."),
        START_GAME("숫자 야구 게임을 시작합니다."),
        END_GAME("게임을 종료합니다"),
        START_INNING("라운드를 시작합니다"),
        END_INNING("라운드를 종료합니다");

        private final String msg;
        Menu(String msg){
            this.msg = msg;
        }
    }
}
