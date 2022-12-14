package org.cleancode.racing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        // 인스턴스에 의존하는 메서드의 경우
        // 인스턴스를 인자로 넘겨주는 방식으로 변경하여 의존성을 제거한다.
        // 이 경우 테스트할 때, static findWinners()만 테스트를 하면 되고,
        // 실제 사용은 Cars.findWinners()를 사용하면 된다.
        // 테스트하기 쉬운 구조로 변경된다.
        return findWinners(this.cars, getMaxPosition());
    }

    public static List<Car> findWinners(List<Car> cars, Position maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }

    public Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("우승한 자동차가 없습니다."));
    }

    /*
    이 메소드는 테스트할 때,
    생성자와 같이 테스트해야 하므로 단일 테스트가 어렵다.
    public List<Car> findWinners(Position maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }
    */
}
