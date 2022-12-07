package org.cleancode.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final NumberGenerator generator = new NumberGenerator();
    private final GameView view = new GameView();

    public RacingGame(){
        String carNames = view.inputCarNames();
        int chances = view.inputTryChances();

        List<String> carList = parseCarName(carNames);

        while (chances > 0){

            chances--;
        }
    }

    public List<String> parseCarName(String carNames){
        return Arrays.stream(carNames.replaceAll(" ", "").split(","))
                .collect(Collectors.toList());
    }

    public List<Car> createPlayers(List<Car> carList){
        return new ArrayList<>();
    }
}
