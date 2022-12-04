package org.cleancode.baseballgame;

import org.cleancode.baseballgame.object.Judge;
import org.cleancode.baseballgame.object.MatchResult;
import org.cleancode.baseballgame.object.Player;
import org.cleancode.baseballgame.view.InputView;
import org.cleancode.baseballgame.view.Menu;
import org.cleancode.baseballgame.view.MenuView;
import org.cleancode.baseballgame.view.ResultView;

import java.util.Random;
import java.util.Scanner;

/**
 * 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
 *
 * 같은 수가 같은 자리에 있으면 스트라이크,
 * 다른 자리에 있으면 볼,
 * 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
 * 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
 *
 * e.g.
 * 상대방(컴퓨터)의 수가 425일 때,
 * 123을 제시한 경우 : 1스트라이크,
 * 456을 제시한 경우 : 1볼 1스트라이크,
 * 789를 제시한 경우 : 낫싱
 *
 * 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다.
 * 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
 *
 * 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고,
 * 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
 *
 * 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
 */
public class BaseBallGame {
    private final InputView inputView = new InputView();
    private final MenuView menuView = new MenuView();
    private final ResultView resultView = new ResultView();
    private final Scanner sc = new Scanner(System.in);
    public String getStringInput(){
        return sc.nextLine();
    }

    private final Player player = new Player();

    public BaseBallGame(){
        String answer = getRandomAnswer();
        boolean keepGoing = true;
        while (keepGoing){
            keepGoing = playInning(answer);
        }

    }
    public String getRandomAnswer(){
        // 111~999까지 정수 반환
        // 0이 나오지 않도록 해야함
        int i__ = (1 + new Random().nextInt(8)) * 100;
        int _i_ = (1 + new Random().nextInt(8)) * 10;
        int __i = 1 + new Random().nextInt(8);
        return String.valueOf(i__ + _i_ + __i);
    }

    public boolean playInning(String answer){
        inputView.display(Menu.START_INNING);
        MatchResult result = Judge.judge(getStringInput(), answer);
        player.getRecords().add(result);
        if(result.getStrikes() == 3) {
            resultView.display(Menu.END_GAME);
            return false;
        }
        resultView.display(Menu.END_INNING);
        return true;
    }
}
