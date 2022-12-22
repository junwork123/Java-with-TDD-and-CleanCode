package org.cleancode.rentcompany;

import org.cleancode.rentcompany.cars.Car;
import org.cleancode.rentcompany.cars.CarFactory;
import org.cleancode.rentcompany.cars.K5;
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

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    EngineConfig engineConfig;
    FuelTankConfig fuelTankConfig;

    @BeforeEach
    public void setUp() {
        fuelTankConfig = new FuelTankConfig.Builder()
                .type(TankType.BATTERY)
                .size(TankSize.BIG)
                .build();
        engineConfig = new EngineConfig.Builder()
                .type(EngineType.DIESEL)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
    }

    @Test
    public void create(){
        Car car = CarFactory.create(K5.class, fuelTankConfig, engineConfig);

        assertThat(car.getName()).isEqualTo("K5");
        assertThat(car.getFuelTank()).isEqualTo(FuelTankFactory.create(fuelTankConfig));
        assertThat(car.getEngine()).isEqualTo(EngineFactory.create(engineConfig));
    }
}
