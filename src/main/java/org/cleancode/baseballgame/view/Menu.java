package org.cleancode.baseballgame.view;

public enum Menu {
    WELCOME("안녕하세요! 숫자 야구 게임에 오신 것을 환영합니다."),
    START_GAME("숫자 야구 게임을 시작합니다"),
    TYPE_INPUT("3자리 숫자를 입력해주세요 : "),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료!"),
    END_GAME("게임을 종료합니다");

    private final String msg;

    Menu(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
