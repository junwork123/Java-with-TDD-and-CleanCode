package org.cleancode.rentcompany.fueltanks;

import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankType;

public abstract class FuelTank {
    private final double capacity;
    private final TankType type;

    protected FuelTank(FuelTankConfig config) {
        this.capacity = config.getSize().getCapacity();
        this.type = config.getType();
    }

    public double getCapacity() {
        return capacity;
    }

    public TankType getType() {
        return type;
    }
}
