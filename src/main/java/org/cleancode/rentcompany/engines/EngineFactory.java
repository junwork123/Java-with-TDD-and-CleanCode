package org.cleancode.rentcompany.engines;

import org.cleancode.rentcompany.engines.config.EngineConfig;

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
}
