package org.cleancode.rentcompany;

import org.cleancode.rentcompany.cars.Car;
import org.cleancode.rentcompany.cars.CarFactory;
import org.cleancode.rentcompany.cars.config.CarConfig;
import org.cleancode.rentcompany.engines.EngineFactory;
import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.engines.config.EngineType;
import org.cleancode.rentcompany.engines.config.HorsePower;
import org.cleancode.rentcompany.engines.config.InjectionType;
import org.cleancode.rentcompany.fueltanks.FuelTankFactory;
import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankSize;
import org.cleancode.rentcompany.fueltanks.config.TankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    EngineConfig dieselConfig;
    FuelTankConfig batteryConfig;
    public CarConfig carConfig;

    @BeforeEach
    public void setUp() {
        dieselConfig = new EngineConfig.Builder()
                .type(EngineType.DIESEL)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
        batteryConfig = new FuelTankConfig.Builder()
                .type(TankType.BATTERY)
                .size(TankSize.BIG)
                .build();
        carConfig = new CarConfig.Builder()
                .fuelTank(FuelTankFactory.create(batteryConfig))
                .engine(EngineFactory.create(dieselConfig))
                .name("Avante")
                .build();
    }

    @Test
    public void create(){
        Car car = CarFactory.create(carConfig);

        assertThat(car.getName()).isEqualTo("Avante");
        assertThat(car.getFuelTank()).isEqualTo(FuelTankFactory.create(batteryConfig));
        assertThat(car.getEngine()).isEqualTo(EngineFactory.create(dieselConfig));
    }
}
