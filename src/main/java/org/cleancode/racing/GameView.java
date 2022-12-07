package org.cleancode.racing;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GameView {
    private final Scanner sc = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요");
        System.out.println("이름은 쉼표(,)를 기준으로 구분합니다.");
        return sc.nextLine();
    }

    public int inputTryChances() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    public void displayResult(List<Car> carList) {
        System.out.println("실행 결과");
        carList.forEach(car ->
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
    }

    public void displayWinner(List<Car> winnerList) {
        Optional<String> stringOptional = winnerList.stream()
                .map(Car::getName)
                .reduce((s, s2) -> s + ", " + s2);
        if(stringOptional.isEmpty()){
            return;
        }
        System.out.print(stringOptional.get() + "가 최종 우승했습니다.");
    }
}
