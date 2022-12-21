package org.cleancode.rentcompany.cars;

import org.cleancode.rentcompany.cars.config.CarConfig;

public class CarFactory {
    public static Car create(CarConfig config) {
        switch (config.getName()) {
            case "Avante":
                return new Avante(config);
            case "Sonata":
                return new Sonata(config);
            case "K5":
                return new K5(config);
            default:
                throw new IllegalArgumentException("잘못된 차량 이름입니다.");
        }
    }
}
