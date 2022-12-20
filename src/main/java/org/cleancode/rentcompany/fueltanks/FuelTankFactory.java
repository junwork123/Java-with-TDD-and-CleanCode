package org.cleancode.rentcompany.fueltanks;

import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;

public class FuelTankFactory {
public static FuelTank create(FuelTankConfig config) {
        switch (config.getType()) {
            case LIQUID:
                return new LiquidFuelTank(config);
            case GAS:
                return new GasFuelTank(config);
            case BATTERY:
                return new BatteryFuelTank(config);
            default:
                throw new IllegalArgumentException("Unknown fuel tank type: " + config.getType());
        }
    }
}
