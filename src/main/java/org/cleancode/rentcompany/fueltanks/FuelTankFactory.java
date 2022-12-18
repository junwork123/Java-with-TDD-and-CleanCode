package org.cleancode.rentcompany.fueltanks;

import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankSize;
import org.cleancode.rentcompany.fueltanks.config.TankType;

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

    public static FuelTank createLiquidFuelTank() {
        FuelTankConfig config = new FuelTankConfig.Builder()
                .type(TankType.LIQUID)
                .size(TankSize.SMALL)
                .build();
        return new LiquidFuelTank(config);
    }
    public static FuelTank createGasFuelTank() {
        FuelTankConfig config = new FuelTankConfig.Builder()
                .type(TankType.GAS)
                .size(TankSize.SMALL)
                .build();
        return new GasFuelTank(config);
    }
    public static FuelTank createBatteryFuelTank() {
        FuelTankConfig config = new FuelTankConfig.Builder()
                .type(TankType.BATTERY)
                .size(TankSize.SMALL)
                .build();
        return new BatteryFuelTank(config);
    }
}
