package org.cleancode.rentcompany.cars;

import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.engines.config.EngineType;
import org.cleancode.rentcompany.engines.config.HorsePower;
import org.cleancode.rentcompany.engines.config.InjectionType;
import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankSize;
import org.cleancode.rentcompany.fueltanks.config.TankType;

public class CarFactory {
    public static Car create(Class<? extends Car> carClass, FuelTankConfig fuelTankConfig, EngineConfig engineConfig) {
        if(carClass.equals(K5.class)) {
            return K5.create(fuelTankConfig, engineConfig);
        } else if(carClass.equals(Sonata.class)) {
            return Sonata.create(fuelTankConfig, engineConfig);
        } else if(carClass.equals(Avante.class)) {
            return Avante.create(fuelTankConfig, engineConfig);
        } else {
            throw new IllegalArgumentException("Unknown car type");
        }
    }
    public static Car create(Class<? extends Car> carClass) {
        EngineConfig engineConfig = new EngineConfig.Builder()
                .type(EngineType.DIESEL)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
        FuelTankConfig fuelTankConfig = new FuelTankConfig.Builder()
                .type(TankType.BATTERY)
                .size(TankSize.BIG)
                .build();
        return create(carClass, fuelTankConfig, engineConfig);
    }
}
