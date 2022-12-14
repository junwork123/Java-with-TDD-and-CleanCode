package org.cleancode.racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void findWinner() {
        Car pobi = new Car("pobi", 8);
        Car crong = new Car("crong", 8);
        Car honux = new Car("honux", 4);

        List<Car> carList = List.of(pobi, crong, honux);
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners()).containsExactly(pobi, crong);
    }
}