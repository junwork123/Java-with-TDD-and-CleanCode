package org.cleancode.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car = new Car("test");
    @Test
    void move() {
        MovingStrategy strategy = new MovingStrategy() {
            @Override
            public boolean movable() {
                // return getRandomNo() >= OIL_THRESHOLD;
                // 랜덤값을 고정값으로 대체할 수 있다.
                return false;
            }
        }; // MovingStrategy strategy = () -> false 로 대체 가능
        assertThat(car.move(strategy)).isEqualTo(new Position(Position.DEFAULT_DISTANCE));
        assertThat(car.move(() -> true)).isEqualTo(new Position(Position.DEFAULT_DISTANCE + 1));
    }
}