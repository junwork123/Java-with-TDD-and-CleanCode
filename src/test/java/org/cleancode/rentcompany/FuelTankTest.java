package org.cleancode.rentcompany;

import org.cleancode.rentcompany.fueltanks.*;
import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankSize;
import org.cleancode.rentcompany.fueltanks.config.TankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FuelTankTest {
    FuelTankConfig batteryConfig;
    FuelTankConfig gasConfig;
    FuelTankConfig liquidConfig;
    @BeforeEach
    public void setUp() {
        batteryConfig = new FuelTankConfig.Builder()
                .type(TankType.BATTERY)
                .size(TankSize.BIG)
                .build();
        gasConfig = new FuelTankConfig.Builder()
                .type(TankType.GAS)
                .size(TankSize.MIDDLE)
                .build();
        liquidConfig = new FuelTankConfig.Builder()
                .type(TankType.LIQUID)
                .size(TankSize.SMALL)
                .build();
    }

    @Test
    public void create(){
        FuelTank fuelTank = FuelTankFactory.create(batteryConfig);
        assertThat(fuelTank.getType()).isEqualTo(TankType.BATTERY);
        assertThat(fuelTank.getSize()).isEqualTo(TankSize.BIG);
    }

    @Test
    public void createVariousTank(){
        assertThat(FuelTankFactory.create(batteryConfig)).isInstanceOf(BatteryFuelTank.class);
        assertThat(FuelTankFactory.create(gasConfig)).isInstanceOf(GasFuelTank.class);
        assertThat(FuelTankFactory.create(liquidConfig)).isInstanceOf(LiquidFuelTank.class);
    }
}
