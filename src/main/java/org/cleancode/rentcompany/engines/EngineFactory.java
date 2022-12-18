package org.cleancode.rentcompany.engines;

import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.engines.config.EngineType;
import org.cleancode.rentcompany.engines.config.HorsePower;
import org.cleancode.rentcompany.engines.config.InjectionType;

public class EngineFactory {
    public static Engine create(EngineConfig config) {
        switch (config.getEngineType()) {
            case ELECTRIC:
                return new ElectricEngine(config);
            case GAS:
                return new GasEngine(config);
            case DIESEL:
                return new DieselEngine(config);
            default:
                throw new IllegalArgumentException("Unknown fuel tank type: " + config.getEngineType());
        }
    }

    public static Engine createElectricEngine() {
        EngineConfig config = new EngineConfig.Builder()
                .type(EngineType.ELECTRIC)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
        return new ElectricEngine(config);
    }
    public static Engine createGasEngine() {
        EngineConfig config = new EngineConfig.Builder()
                .type(EngineType.GAS)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
        return new GasEngine(config);
    }
    public static Engine createDieselEngine() {
        EngineConfig config = new EngineConfig.Builder()
                .type(EngineType.DIESEL)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
        return new DieselEngine(config);
    }

}
