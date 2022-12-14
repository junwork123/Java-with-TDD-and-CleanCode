package org.cleancode.racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public RacingGame(){
        GameView view = new GameView();
        String carNames = view.inputCarNames();
        int chances = view.inputTryChances();

        List<String> carNameList = parseCarName(carNames);
        List<Car> players = createPlayers(carNameList);
        while (chances > 0){
            players.forEach(car -> car.move(new RandomMovingStrategy()));
            chances--;
            view.displayResult(players);
        }
        Cars cars = new Cars(players);
        view.displayWinner(cars.findWinners());
    }

    public List<String> parseCarName(String carNames){
        return Arrays.stream(carNames.replaceAll(" ", "").split(","))
                .collect(Collectors.toList());
    }

    public List<Car> createPlayers(List<String> carNameList){
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
