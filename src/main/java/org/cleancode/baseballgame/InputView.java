package org.cleancode.baseballgame;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class InputView implements View {

    private Scanner sc;
    String getTextInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void display(Menu menu) {
        Arrays.stream(InnerMenu.values())
                .filter(innerMenu -> innerMenu.menu.equals(menu))
                .findFirst()
                .ifPresent(innerMenu -> System.out.println(innerMenu.msg));
    }

    enum InnerMenu{
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
