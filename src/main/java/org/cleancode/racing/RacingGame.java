package org.cleancode.racing;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final NumberGenerator generator = new NumberGenerator();
    private final GameView view = new GameView();

    public RacingGame(){
        String carNames = view.inputCarNames();
        int chances = view.inputTryChances();

        List<String> carNameList = parseCarName(carNames);
        List<Car> players = createPlayers(carNameList);
        while (chances > 0){
            players.forEach(car -> car.move(generator.getRandomNumber()));
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
        OptionalInt maxOptional = carList.stream()
                .flatMapToInt(car -> IntStream.of(car.getPosition()))
                .max();
        if(maxOptional.isEmpty()) {
            return null;
        }
        int max = maxOptional.getAsInt();
        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }
}
