package org.cleancode.rentcompany.cars;

import org.cleancode.rentcompany.cars.config.CarConfig;
import org.cleancode.rentcompany.engines.EngineFactory;
import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.fueltanks.FuelTankFactory;
import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;

public class K5 extends Car {
    protected K5(CarConfig config) {
        super(config);
    }

    protected static K5 create(FuelTankConfig fuelTankConfig, EngineConfig engineConfig) {
        CarConfig carConfig = new CarConfig.Builder()
                .fuelTank(FuelTankFactory.create(fuelTankConfig))
                .engine(EngineFactory.create(engineConfig))
                .name("K5")
                .build();
        return new K5(carConfig);
    }

    @Override
    public double getDistancePerLiter() {
        return 13;
    }
}
