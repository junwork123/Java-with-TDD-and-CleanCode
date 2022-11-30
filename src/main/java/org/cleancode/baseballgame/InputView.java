package org.cleancode.baseballgame;

public class InputView implements View {
    private Menu menu;
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void display() {
        System.out.println(menu.msg);
    }
    public enum Menu{
        START_GAME("숫자 야구 게임을 시작하시겠습니까?"),
        END_GAME("게임을 종료하시겠습니까?"),
        START_INNING("3자리 숫자를 입력해주세요");

        private final String msg;
        Menu(String msg){
            this.msg = msg;
        }
    }
}
