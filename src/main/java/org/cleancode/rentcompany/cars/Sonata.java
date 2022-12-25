package org.cleancode.rentcompany.cars;

import org.cleancode.rentcompany.cars.config.CarConfig;
import org.cleancode.rentcompany.engines.EngineFactory;
import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.fueltanks.FuelTankFactory;
import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;

public class Sonata extends Car {
    protected Sonata(CarConfig config) {
        super(config);
    }
    protected static Sonata create(FuelTankConfig fuelTankConfig, EngineConfig engineConfig) {
        CarConfig carConfig = new CarConfig.Builder()
                .fuelTank(FuelTankFactory.create(fuelTankConfig))
                .engine(EngineFactory.create(engineConfig))
                .name("K5")
                .build();
        return new Sonata(carConfig);
    }

    @Override
    public double getDistancePerLiter() {
        return 15;
    }
}
