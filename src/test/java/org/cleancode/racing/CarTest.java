package org.cleancode.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car = new Car("test");
    @Test
    void move() {
        assertThat(car.move(0)).isEqualTo(Car.DEFAULT_DISTANCE);
        assertThat(car.move(Car.OIL_THRESHOLD-1)).isEqualTo(Car.DEFAULT_DISTANCE);
        assertThat(car.move(Car.OIL_THRESHOLD)).isEqualTo(Car.DEFAULT_DISTANCE+1);
        assertThat(car.move(Car.OIL_THRESHOLD+1)).isEqualTo(Car.DEFAULT_DISTANCE+2);
    }
}