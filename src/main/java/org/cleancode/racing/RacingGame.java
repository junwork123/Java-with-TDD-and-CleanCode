package org.cleancode.racing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<Car> winnerList = whoIsWinner(players);
        view.displayWinner(winnerList);
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

    public List<Car> whoIsWinner(List<Car> carList){
        Optional<Position> maxOptional = carList.stream()
                .flatMap(car -> Stream.of(car.getPosition()))
                .max(Position::compareTo);
        if(maxOptional.isEmpty()) {
            return null;
        }
        Position max = maxOptional.get();
        return carList.stream()
                .filter(car -> car.getPosition().equals(max))
                .collect(Collectors.toList());
    }
}
